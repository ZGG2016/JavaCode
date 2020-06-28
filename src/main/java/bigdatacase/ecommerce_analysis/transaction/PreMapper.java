package bigdatacase.ecommerce_analysis.transaction;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/*
 * 输出：itemid  1
 * 
 * */

public class PreMapper extends Mapper<LongWritable,Text,LongWritable,IntWritable> {

	private static final LongWritable k = new LongWritable();
	private static final IntWritable v = new IntWritable(1);
	
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		String[] splited = value.toString().split(",");	
		
		if(splited[2].equals("transaction")){
			k.set(Long.parseLong(splited[3])); //itemid			
			context.write(k, v);
		}
		
	}	
}
