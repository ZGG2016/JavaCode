package bigdatacase.airbnb_analysis;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class CalDriver {

	public static void main(String[] args) throws Exception {

		Configuration conf = new Configuration();
		
		Job job = Job.getInstance(conf);
		
		job.setJarByClass(CalDriver.class);
		
		job.setMapperClass(CalMapper.class);			
		job.setReducerClass(CalReducer.class);
				
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);	
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		Path path = new Path("hdfs://192.168.0.103:9000/Airbnb/caloutput");
		FileSystem fs =path.getFileSystem(conf);
		if(fs.exists(path)){
			fs.delete(path,true);
		}
		
		FileInputFormat.setInputPaths(job, new Path("hdfs://192.168.0.103:9000/Airbnb/input2/calendar.csv"),
										new Path("hdfs://192.168.0.103:9000/Airbnb/input2/calendar (1).csv"),
										new Path("hdfs://192.168.0.103:9000/Airbnb/input2/calendar (2).csv"),
										new Path("hdfs://192.168.0.103:9000/Airbnb/input2/calendar (3).csv"),
										new Path("hdfs://192.168.0.103:9000/Airbnb/input2/calendar (4).csv"),
										new Path("hdfs://192.168.0.103:9000/Airbnb/input2/calendar (5).csv"),
										new Path("hdfs://192.168.0.103:9000/Airbnb/input2/calendar (6).csv"),
										new Path("hdfs://192.168.0.103:9000/Airbnb/input2/calendar (7).csv"),
										new Path("hdfs://192.168.0.103:9000/Airbnb/input2/calendar (8).csv")
										);
		
		FileOutputFormat.setOutputPath(job, new Path("hdfs://192.168.0.103:9000/Airbnb/caloutput"));
		
		boolean res = job.waitForCompletion(true);

		System.exit(res?0:1);

	}

}
