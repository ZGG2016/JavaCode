package bigdatacase.airbnb_analysis;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class RepDriver {

	public static void main(String[] args) throws Exception {

		Configuration conf = new Configuration();
		
		Job job = Job.getInstance(conf);
		
		job.setJarByClass(RepDriver.class);
		
		job.setMapperClass(RepMapper.class);
		job.setReducerClass(RepReducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		
		job.setOutputKeyClass(LongWritable.class);
		job.setOutputValueClass(Text.class);
		
		Path path = new Path("hdfs://192.168.0.103:9000/Airbnb/repoutput");
		FileSystem fs =path.getFileSystem(conf);
		if(fs.exists(path)){
			fs.delete(path,true);
		}
		
		FileInputFormat.setInputPaths(job, new Path("hdfs://192.168.0.103:9000/Airbnb/caloutput"),
						new Path("hdfs://192.168.0.103:9000/Airbnb/listoutput"));
		
		FileOutputFormat.setOutputPath(job, new Path("hdfs://192.168.0.103:9000/Airbnb/repoutput"));
		
		boolean res = job.waitForCompletion(true);

		System.exit(res?0:1);

	}

}
