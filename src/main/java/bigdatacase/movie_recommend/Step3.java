package bigdatacase.movie_recommend;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class Step3 {

    private final static Pattern DELIMITER = Pattern.compile("[\t,]");
    private static final String input_path = "hdfs://zgg:9000/output/recommend/step2-output";
    private static final String output_path = "hdfs://zgg:9000/output/recommend/step3-output";

    public static class Step3Mapper extends Mapper<LongWritable, Text, Text, Text> {
        /*
         * map输入：<userID1,userID2  similarity>
         *    输出：<userID1  userID2,similarity>
         * */
        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {

            Text k = new Text();
            Text v = new Text();
            String[] splited = DELIMITER.split(value.toString());

            if (splited.length >= 3){
                k.set(splited[0]);
                v.set(splited[1] + "," + splited[2]);
                context.write(k, v);
            }
        }
    }

    public static class Step3Reducer extends Reducer<Text, Text, Text, Text> {
        /*
         * reduce输入：<userID1  userID2,similarity>
         *       输出: <userID1  userID2,similarity,userID3,similarity>
         *
         * */

        int NEIGHBORHOOD_NUM = 2;
        @Override
        protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context)
                throws IOException, InterruptedException {

            Map<Double, String> map = new HashMap<Double, String>();

            for (Text value : values) {

                String[] splited = DELIMITER.split(value.toString());

                if (splited.length >= 2){
                    map.put(Double.parseDouble(splited[1]), splited[0]);  //similarity,userID2
                }
            }

            List<Double> list = new ArrayList<Double>();
            Iterator<Double> iter = map.keySet().iterator();
            while (iter.hasNext()) {
                Double similarity = iter.next();  //similarity--key
                list.add(similarity);
            }

            //通过比较器来实现排序
            Collections.sort(list,new Comparator<Double>() {
                //降序排序
                public int compare(Double o1, Double o2) {
                    return o2.compareTo(o1);
                }
            });

            String v = "";
            for (int i = 0; i < NEIGHBORHOOD_NUM && i < list.size(); i++){
                v += "," + map.get(list.get(i)) + "," + String.format("%.7f", list.get(i));
            }
            context.write(key, new Text(v.substring(1)));
        }
    }

    /*
     * 用户相似度最高的前2个用户
     * */
    public static void main(String[] args) throws Exception {

        BasicConfigurator.configure();
        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf);

        job.setJarByClass(Step3.class);

        job.setMapperClass(Step3Mapper.class);
        job.setReducerClass(Step3Reducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        Path path = new Path(output_path);
        FileSystem fs =path.getFileSystem(conf);
        if(fs.exists(path)){
            fs.delete(path,true);
        }

        FileInputFormat.setInputPaths(job, new Path(input_path));
        FileOutputFormat.setOutputPath(job, path);

        boolean res = job.waitForCompletion(true);

        System.exit(res?0:1);
    }
}
