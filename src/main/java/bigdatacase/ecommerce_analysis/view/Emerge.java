package bigdatacase.ecommerce_analysis.view;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Emerge {

	public static void main(String[] args) throws Exception {
		
		Configuration conf = new Configuration();
		
		Job job = Job.getInstance(conf);
		
		job.setJarByClass(Emerge.class);
		
		job.setMapperClass(EmergeMapper.class);
		job.setReducerClass(EmergeReducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		Path path = new Path("hdfs://192.168.0.103:9000/viewoutput/Emerge");
		FileSystem fs =path.getFileSystem(conf);
		if(fs.exists(path)){
			fs.delete(path,true);
		}
		
		FileInputFormat.setInputPaths(job, new Path("hdfs://192.168.0.103:9000/viewoutput/pre"),
				new Path("hdfs://192.168.0.103:9000/viewoutput/part1"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://192.168.0.103:9000/viewoutput/Emerge"));
		
		boolean res = job.waitForCompletion(true);

		System.exit(res?0:1);
	}
}
