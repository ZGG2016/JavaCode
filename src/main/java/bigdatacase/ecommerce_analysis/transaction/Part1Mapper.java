package bigdatacase.ecommerce_analysis.transaction;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
/*
 * 输出：itemid  property
 *  
 * */
public class Part1Mapper extends Mapper<LongWritable,Text,LongWritable,Text> {

	private static final LongWritable k = new LongWritable();
	private static final Text v = new Text();
	
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		String[] splited = value.toString().split(",");
		if(splited[0].equals("timestamp")){
			return;
		}
		k.set(Long.parseLong(splited[1]));
		v.set(splited[2]);
		context.write(k, v);
		
	}
}
