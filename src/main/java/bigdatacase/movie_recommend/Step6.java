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

public class Step6 {

    private final static Pattern DELIMITER = Pattern.compile("[\t,]");
    private static final String input_path = "hdfs://zgg:9000/output/recommend/step5-output";
    private static final String output_path = "hdfs://zgg:9000/output/recommend/step6-output";

    public static class Step6Mapper extends Mapper<LongWritable, Text, Text, Text> {
        /* map：
         *    输入：<userID  movieID,average pref>
         *    输出：<userID  movieID,average pref>
         * */

        private final static Text k = new Text();
        private final static Text v = new Text();
        @Override
        protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
                throws IOException, InterruptedException {
            String[] splited = DELIMITER.split(value.toString());

            if (splited.length >= 3)
            {
                k.set(splited[0]);
                v.set(splited[1] + "," + splited[2]);
                context.write(k, v);
            }
        }
    }

    public static class Step6Reducer extends Reducer<Text, Text, Text, Text> {
        /*
         * reduce输入：<userID  movieID,average pref>
         *       输出：<userID  movieID{average pref}>
         *
         * */

        private final int RECOMMENDER_NUM = 1;

        @Override
        protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context)
                throws IOException, InterruptedException {

            Map<Double, String> map = new HashMap<Double, String>();

            for (Text value : values) {
                String[] splited =DELIMITER.split(value.toString());

                if (splited.length >= 2){
                    map.put(Double.parseDouble(splited[1]), splited[0]);  //average pref,movieID
                }
            }

            List<Double> list = new ArrayList<Double>();
            Iterator<Double> iter = map.keySet().iterator();
            while (iter.hasNext()) {
                Double similarity = iter.next();
                list.add(similarity);
            }

            //然后通过比较器来实现排序
            Collections.sort(list,new Comparator<Double>() {
                //降序排序
                public int compare(Double o1, Double o2) {
                    return o2.compareTo(o1);
                }
            });

            String v = "";   //取预测评分最高
            for (int i = 0; i < RECOMMENDER_NUM && i < list.size(); i++){

                if (list.get(i).compareTo(new Double(0.001)) > 0)  {
                    v = "," +map.get(list.get(i)) + "," + String.format("%.2f", list.get(i));
                }
                if (!v.isEmpty()){
                    context.write(key, new Text(v.substring(1)));
                }
                else{
                    context.write(key, new Text("none"));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BasicConfigurator.configure();
        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf);

        job.setJarByClass(Step6.class);

        job.setMapperClass(Step6Mapper.class);
        job.setReducerClass(Step6Reducer.class);

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
        FileOutputFormat.setOutputPath(job,path);

        System.exit(job.waitForCompletion(true)?0:1);
    }

}
