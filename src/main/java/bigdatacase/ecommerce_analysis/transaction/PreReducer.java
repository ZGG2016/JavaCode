package bigdatacase.ecommerce_analysis.transaction;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class PreReducer extends Reducer<LongWritable, IntWritable, LongWritable, IntWritable> {

	private static final IntWritable v = new IntWritable();
	@Override
	protected void reduce(LongWritable key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException {
		
		int sum=0;
		StringBuilder sb = new StringBuilder();
		for(IntWritable val : values){
			sum=sum+val.get();
		}
		v.set(sum);
		context.write(key, v);
	}	
}
