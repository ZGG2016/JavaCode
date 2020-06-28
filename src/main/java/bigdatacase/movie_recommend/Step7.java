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
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Step7 {

    private final static Pattern DELIMITER = Pattern.compile("[\t|,]");
    private static final String input_path1 = "hdfs://zgg:9000/output/recommend/step6-output";
    private static final String input_path2 = "hdfs://zgg:9000/data/recommend/u.item";
    private static final String output_path = "hdfs://zgg:9000/output/recommend/step7-output";

    public static class Step7Mapper extends Mapper<LongWritable, Text, Text, Text> {


        private String flag;

        @Override
        protected void setup(Mapper<LongWritable, Text, Text, Text>.Context context)
                throws IOException, InterruptedException {
            FileSplit split = (FileSplit) context.getInputSplit();
            flag = split.getPath().getParent().getName();// 判断读的数据集

            System.out.println(flag);
        }

        @Override
        protected void map(LongWritable key, Text value,Context context)
                throws IOException, InterruptedException {

            String[] splited = DELIMITER.split(value.toString());

            if (flag.equals("step6-output")) {
                Text k = new Text(splited[1]);  //把电影ID作为key
                Text v = new Text("A:"+splited[0]+","+splited[2]);  //用户ID，评分
                context.write(k, v);
            } else if(flag.equals("recommend")){
                Text k = new Text(splited[0]);  //电影ID
                Text v = new Text("B:"+splited[1]); //电影名称
                context.write(k, v);
            }
        }
    }

    public static class Step7Reducer extends Reducer<Text, Text,Text, Text> {

        private final static Text k = new Text();
        private final static Text v = new Text();
        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context)
                throws IOException, InterruptedException {

            List<String> list1 = new ArrayList<String>();
            List<String> list2 = new ArrayList<String>();

            for(Text value : values){
                String str = value.toString();
                if(str.startsWith("B:")){
                    list1.add(str.substring(2));//把电影名称存入集合
                }
                else if(str.startsWith("A:")){
                    list2.add(str.substring(2)); //用户ID，评分
                }
            }
            for(int i=0;i<list1.size();i++){
                for(int j=0;j<list2.size();j++){
                    k.set(list2.get(j).split(",")[0]);
                    v.set(list1.get(i)+"\t"+list2.get(j).split(",")[1]);
                    context.write(k, v);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BasicConfigurator.configure();
        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf);

        job.setJarByClass(Step7.class);

        job.setMapperClass(Step7Mapper.class);
        job.setReducerClass(Step7Reducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        Path path = new Path(output_path);
        FileSystem fs =path.getFileSystem(conf);
        if(fs.exists(path)){
            fs.delete(path,true);
        }

        FileInputFormat.setInputPaths(job, new Path(input_path1),new Path(input_path2));
        FileOutputFormat.setOutputPath(job,path);

        System.exit(job.waitForCompletion(true)?0:1);
    }

}
