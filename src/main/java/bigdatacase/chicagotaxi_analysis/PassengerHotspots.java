package bigdatacase.chicagotaxi_analysis;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.log4j.BasicConfigurator;

// hadoop处理数据--->sqoop传输数据--->mysql存储数据--->django展示数据

public class PassengerHotspots {
    static class Maps extends Mapper<LongWritable, Text, Text, IntWritable> {
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            StringBuffer gpsStr = null;
            //对每次读入的一行数据进行逗号分割，得到一个数组
            String[] cells = value.toString().split(",");
            //判断数据长度是否有23个字段，不足的视为无效数据，并排除第一行
            if (cells.length == 23&&!"Pickup Centroid Longitude".equals(cells[17])&&!"Pickup Centroid Latitude".equals(cells[18])) {
                if (!cells[4].isEmpty() && !cells[17].isEmpty() && !cells[18].isEmpty()) {
                    gpsStr = new StringBuffer();
                    gpsStr.append(cells[17]);
                    gpsStr.append("::");
                    gpsStr.append(cells[18]);
                    String str = gpsStr.toString();
                    context.write(new Text(str), new IntWritable(1)); //key:(经度：：纬度)  value:1
                }
                //通过对数据字段的分析，有些字段有中存在逗号，所以行的数组长度有等于24
            } else if (cells.length == 24) {
                if (!cells[4].isEmpty() && !cells[18].isEmpty() && !cells[19].isEmpty()) {
                    gpsStr = new StringBuffer();
                    gpsStr.append(cells[18]);
                    gpsStr.append("::");
                    gpsStr.append(cells[19]);
                    String str = gpsStr.toString();
                    context.write(new Text(str), new IntWritable(1));
                }
            }
        }
    }


    static class Reduces extends Reducer<Text, IntWritable, Text, Text> {
        @Override
        protected void reduce(Text key, Iterable<IntWritable> value, Context context)throws IOException, InterruptedException {

            int count = 0;
            //对重复出现的位置进行迭代统计
            for (IntWritable i : value) {
                count += Double.parseDouble(i.toString());
            }
            String[] cell = key.toString().split("::");
            //大于20次的数据，视为载客热点
            if(count>20){
                context.write(key, new Text(String.valueOf(count))); //key:(经度：：纬度)  value:计数值


            }
        }
    }

    public static void main(String[] args) throws Exception {

        BasicConfigurator.configure();

        Configuration conf = new Configuration();

        Path outpath = new Path("hdfs://192.168.0.9:9000/output");
        FileSystem fs =outpath.getFileSystem(conf);
        if(fs.exists(outpath)){
            fs.delete(outpath,true);
        }

        Job job = Job.getInstance(conf);
        job.setJobName("Passenger Hotspots");

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.setJarByClass(PassengerHotspots.class);
        job.setMapperClass(Maps.class);
        job.setReducerClass(Reduces.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        FileInputFormat.setInputPaths(job, new Path("hdfs://192.168.0.9:9000/input/Taxi_Trips_test.csv"));
        FileOutputFormat.setOutputPath(job, outpath);
        job.waitForCompletion(true);

    }
}
