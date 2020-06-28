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
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Step1 {

    private static final String input_path = "hdfs://zgg:9000/data/recommend/u.data";
    private static final String output_path = "hdfs://zgg:9000/output/recommend/step1-output";

    public static class Step1Mapper extends Mapper<LongWritable, Text, Text, Text> {
        /*
         * map  输入：<userID  movieID,pref>
         *      输出：<movieID  userID,pref>
         * */
        private final static Text k = new Text();
        private final static Text v = new Text();
        private final static Pattern DELIMITER = Pattern.compile("[\t,]");

        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            //以制表符划分数据
            String[] splited = DELIMITER.split(value.toString());
            if (splited.length >= 3){
                k.set(splited[1]);//splited[1]--movieID
                v.set(splited[0] + "," + splited[2]);//splited[0]，splited[2]---userID,pref
                context.write(k, v);
            }
        }
    }

    public static class Step1Reducer extends Reducer<Text, Text, Text, Text> {

        /*
         * reduce输入：<movieID  userID,pref>
         *       输出：<userID1,userID2  pref1,pref2>
         * */
        private List<String> list = new ArrayList<String>();
        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context)
                throws IOException, InterruptedException {

            list.clear();
            for (Text value : values) {    //value----userID,pref
                //加入到集合中
                list.addAll(java.util.Arrays.asList(value.toString().split(":")));
            }
            //list---多个userID,pref对
            //两次遍历获取用户ID对和电影ID对
            for(String str1:list){
                String[] splited1 = str1.split(",");
                String k1 = splited1[0];
                String v1 = splited1[1];
                for(String str2:list){
                    String[] splited2 = str2.split(",");
                    String k2 = splited2[0];
                    String v2 = splited2[1];
                    context.write(new Text(k1+","+k2), new Text(v1+ "," + v2));
                }
            }

        }
    }

    public static class Step1Combiner extends Reducer<Text, Text, Text, Text> {

        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context)
                throws IOException, InterruptedException {

            Text v = new Text();
            StringBuilder sb = new StringBuilder();
            for(Text value : values){
                sb.append(":"+value);
            }
            v.set(sb.toString().replaceFirst(":", "")); //把":"替换成空格
            context.write(key, v);
        }
    }

    public static void main(String[] args) throws Exception {

        BasicConfigurator.configure();
        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf);

        job.setJarByClass(Step1.class);

        job.setMapperClass(Step1Mapper.class);
        job.setReducerClass(Step1Reducer.class);

        job.setCombinerClass(Step1Combiner.class);

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

        System.exit(job.waitForCompletion(true)?0:1);
    }

}
