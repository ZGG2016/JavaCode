package bigdatacase.airbnb_analysis;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class ListDriver {

	public static void main(String[] args) throws Exception {
		
		Configuration conf = new Configuration();
		
		Job job = Job.getInstance(conf);
		
		job.setJarByClass(ListDriver.class);
		
		job.setMapperClass(ListMapper.class);
		job.setReducerClass(ListReducer.class);
		
		job.setMapOutputKeyClass(LongWritable.class);
		job.setMapOutputValueClass(Text.class);
		
		job.setOutputKeyClass(LongWritable.class);
		job.setOutputValueClass(Text.class);
		
		Path path = new Path("hdfs://192.168.0.103:9000/Airbnb/listoutput");
		FileSystem fs =path.getFileSystem(conf);
		if(fs.exists(path)){
			fs.delete(path,true);
		}
		
		FileInputFormat.setInputPaths(job, new Path("hdfs://192.168.0.103:9000/Airbnb/input2/listings.csv"),
										new Path("hdfs://192.168.0.103:9000/Airbnb/input2/listings (1).csv"),
										new Path("hdfs://192.168.0.103:9000/Airbnb/input2/listings (2).csv"),
										new Path("hdfs://192.168.0.103:9000/Airbnb/input2/listings (3).csv"),
										new Path("hdfs://192.168.0.103:9000/Airbnb/input2/listings (4).csv"),
										new Path("hdfs://192.168.0.103:9000/Airbnb/input2/listings (5).csv"),
										new Path("hdfs://192.168.0.103:9000/Airbnb/input2/listings (6).csv"),
										new Path("hdfs://192.168.0.103:9000/Airbnb/input2/listings (7).csv"),
										new Path("hdfs://192.168.0.103:9000/Airbnb/input2/listings (8).csv"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://192.168.0.103:9000/Airbnb/listoutput"));
			
		boolean res = job.waitForCompletion(true);

		System.exit(res?0:1);
	}
}
