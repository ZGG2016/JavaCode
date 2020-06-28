package bigdatacase.ecommerce_analysis.view;

import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
/*
 * 输入：itemid  count
 * 输出：count  itemid  
 * 
 * */
public class ViewMapper extends Mapper<LongWritable,Text, LongWritable,Text> {
	
	private final static Pattern DELIMITER = Pattern.compile("[\t,]");
	private static final LongWritable k = new LongWritable();
	private static final Text v = new Text();
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		String[] splited = DELIMITER.split(value.toString());	    
		k.set(Long.parseLong(splited[1]));  //count
		v.set(splited[0]+"\t"+splited[2]);  // itemid 属性
		context.write(k, v);
		
	}		
}
