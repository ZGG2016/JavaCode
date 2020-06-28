package bigdatacase.ecommerce_analysis.transaction;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Trans {

	public static void main(String[] args) throws Exception {
		
		Configuration conf = new Configuration();
		
		Job job = Job.getInstance(conf);
		
		job.setJarByClass(Trans.class);
		
		job.setMapperClass(TransMapper.class);
		
		job.setMapOutputKeyClass(LongWritable.class);
		job.setMapOutputValueClass(Text.class);
		
		Path path = new Path("hdfs://192.168.0.103:9000/transoutput/transoutput");
		FileSystem fs =path.getFileSystem(conf);
		if(fs.exists(path)){
			fs.delete(path,true);
		}
		
		FileInputFormat.setInputPaths(job, new Path("hdfs://192.168.0.103:9000/transoutput/Emerge"));
		
		FileOutputFormat.setOutputPath(job, new Path("hdfs://192.168.0.103:9000/transoutput/transoutput"));
			
		boolean res = job.waitForCompletion(true);

		System.exit(res?0:1);
	}
}
