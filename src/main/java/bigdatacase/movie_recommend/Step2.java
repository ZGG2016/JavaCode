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
import java.util.regex.Pattern;

public class Step2 {

    private static final Pattern DELIMITER = Pattern.compile("[\t,]");
    private static final String input_path = "hdfs://zgg:9000/output/recommend/step1-output";
    private static final String output_path = "hdfs://zgg:9000/output/recommend/step2-output";

    public static class Step2Mapper extends Mapper<LongWritable, Text, Text, Text> {
        /*
         * map输入：<userID1,userID2  pref1,pref2>
         * 	  输出：<userID1,userID2  pref1,pref2>
         * */
        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {

            String[] splited = DELIMITER.split(value.toString());
            Text k = new Text();
            Text v = new Text();
            if (splited.length >= 4)
            {
                k.set(splited[0]+ "," +splited[1]);  //userID1,userID2---splited[0],splited[1]
                v.set(splited[2] + "," + splited[3]);  //pref1,pref2---splited[2],splited[3]
                context.write(k, v);
            }
        }
    }

    public static class Step2Reducer extends Reducer<Text, Text, Text, Text> {
        /*
         * reduce输入：<userID1,userID2  pref1,pref2>
         *       输出：<userID1,userID2  similarity>
         * */

        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context)
                throws IOException, InterruptedException {

            Text v = new Text();
            double sum = 0.0;
            double similarity = 0.0;
            int num = 0;

            for (Text value : values) {
                String[] splited = DELIMITER.split(value.toString());

                if (splited.length >= 2)  {
                    //计算欧式距离
                    sum += Math.pow((Double.parseDouble(splited[0]) - Double.parseDouble(splited[1])), 2);
                    num += 1;
                }
            }
            if (sum > 0.00000001){
                similarity = (double)num / (1 + Math.sqrt(sum));   //计算相似度
            }
            v.set(String.format("%.7f", similarity));
            context.write(key, v);
        }
    }

    public static void main(String[] args) throws Exception {

        BasicConfigurator.configure();
        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf);

        job.setJarByClass(Step2.class);

        job.setMapperClass(Step2Mapper.class);
        job.setReducerClass(Step2Reducer.class);

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
