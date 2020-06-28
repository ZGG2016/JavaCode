package bigdatacase.ecommerce_analysis.addtocart;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Part1 {

	public static void main(String[] args) throws Exception {
		
		Configuration conf = new Configuration();
		
		Job job = Job.getInstance(conf);
		
		job.setJarByClass(Part1.class);
		
		job.setMapperClass(Part1Mapper.class);
		job.setReducerClass(Part1Reducer.class);
		
		job.setMapOutputKeyClass(LongWritable.class);
		job.setMapOutputValueClass(Text.class);
		
		job.setOutputKeyClass(LongWritable.class);
		job.setOutputValueClass(Text.class);
		
		Path path = new Path("hdfs://192.168.0.103:9000/addtocartoutput/part1");
		FileSystem fs =path.getFileSystem(conf);
		if(fs.exists(path)){
			fs.delete(path,true);
		}
		
		FileInputFormat.setInputPaths(job, new Path("hdfs://192.168.0.103:9000/input/item_properties_part1.csv"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://192.168.0.103:9000/addtocartoutput/part1"));
		
		boolean res = job.waitForCompletion(true);

		System.exit(res?0:1);
	}
}
