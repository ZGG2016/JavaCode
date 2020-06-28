package bigdatacase.movie_recommend;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.util.regex.Pattern;

public class Step4 {

    private static final String input_path = "hdfs://zgg:9000/data/recommend/u.data";
    private static final String output_path = "hdfs://zgg:9000/output/recommend/step4-output";

    public static class Step4Mapper extends Mapper<LongWritable, Text, IntWritable, Text> {
    /*
    * 输入：<userID  movieID,pref>
    * 输出：<movieID,userID,pref>
    *
    * */
        IntWritable k = new IntWritable();
        Text v = new Text();
        Pattern DELIMITER = Pattern.compile("[\t,]");

        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] splited = DELIMITER.split(value.toString());
            if (splited.length >= 3){
                k.set(Integer.parseInt(splited[1]));
                v.set(splited[0] + "," + splited[2]);
                context.write(k, v);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BasicConfigurator.configure();
        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf);

        job.setJarByClass(Step4.class);

        job.setMapperClass(Step1.Step1Mapper.class);

        job.setMapOutputKeyClass(IntWritable.class);
        job.setMapOutputValueClass(Text.class);

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
