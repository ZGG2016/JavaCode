package bigdatacase.ecommerce_analysis.transaction;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
/*
 * 输入：itemid  property
 * 输出：itemid  property
 * 
 * */
public class Part1Reducer extends Reducer<LongWritable,Text, LongWritable,Text> {

	private final static Text v = new Text();
	
	@Override
	protected void reduce(LongWritable key, Iterable<Text> values,
			Context context) throws IOException, InterruptedException {
		
		
			StringBuilder sb = new StringBuilder();
			for(Text v : values){				
				sb.append(v);
				break;
			}	     
	        v.set(sb.toString());
			context.write(key, v);
		}
	}
	
	

	

