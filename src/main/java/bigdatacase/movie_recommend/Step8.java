package bigdatacase.movie_recommend;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;

public class Step8 {

    private static final String input_path = "hdfs://zgg:9000/output/recommend/step7-output";
    private static final String output_path = "hdfs://zgg:9000/output/recommend/step8-output";

    public static class Step8Mapper extends Mapper<LongWritable, Text,LongWritable, Text> {

        private final static LongWritable k = new LongWritable();
        private final static Text v = new Text();

        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {

            String[] splited = value.toString().split("\t");
            if (splited.length >= 2){
                k.set(Long.parseLong(splited[0]));
                v.set(splited[1]+"\t"+splited[2]);
                context.write(k, v);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BasicConfigurator.configure();
        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf);

        job.setJarByClass(Step8.class);

        job.setMapperClass(Step8Mapper.class);

        job.setMapOutputKeyClass(LongWritable.class);
        job.setMapOutputValueClass(Text.class);

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
