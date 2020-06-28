package hadoopbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.net.URI;

public class WordCount {

    static final String input_path = "hdfs://zgg:9000/in/test.txt";
    static final String output_path = "hdfs://zgg:9000/out";
    public static void main(String[] args) throws Exception {

        BasicConfigurator.configure();

        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI(input_path), conf);

        Path outPath = new Path(output_path);
        if(fs.exists(outPath)){
            fs.delete(outPath,true);
        }

        Job job = Job.getInstance(conf);
        job.setJarByClass(WordCount.class);

        job.setMapperClass(SplitedMapper.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.setReducerClass(CountReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.setInputPaths(job,new Path(input_path));
        FileOutputFormat.setOutputPath(job,new Path(output_path));

        System.exit(job.waitForCompletion(true)? 0: 1);

    }


    public static class SplitedMapper extends Mapper<Object,Text, Text, IntWritable>{
        private final static IntWritable one = new IntWritable(1);  //value
        private Text word = new Text();  //key

        @Override
        protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            String[] token = value.toString().split(" ");
            for(String str : token){
                word.set(str);
                context.write(word,one);
            }
        }
    }

    public static class CountReducer extends Reducer<Text, IntWritable, Text,IntWritable>{
        private IntWritable rlt = new IntWritable();

        @Override
        protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
            int sum = 0;
            for(IntWritable v : values){
                sum += v.get();
            }
            rlt.set(sum);
            context.write(key, rlt);
        }
    }

//    public static class MyPartitioner extends HashPartitioner<Text,IntWritable>{
//        @Override
//        public int getPartition(Text key, IntWritable value, int numReduceTasks) {
//            if(key.toString().length()<3){
//                return 0;
//            }
//            else if(key.toString().length()>=3 && key.toString().length() <6){
//                return 1;
//            }
//            else{
//                return 2;
//            }
//        }
//    }
}
