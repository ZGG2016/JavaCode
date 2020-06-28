package bigdatacase.ecommerce_analysis.transaction;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
/*
 * pre: item sum
 * part1: item SHUXING
 * 
 * */
public class EmergeMapper extends Mapper<LongWritable, Text, Text, Text> {

	private String flag; 
	
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		String[] splited = value.toString().split("\t");
		if(flag.equals("pre")){
			Text k = new Text(splited[0]);
			Text v = new Text("A:"+splited[1]);
			context.write(k, v);
		}
		else if(flag.equals("part1")){
			Text k = new Text(splited[0]);
			Text v = new Text("B:"+splited[1]);
			context.write(k, v);
		}
		
	}

	@Override
	protected void setup(Context context)
			throws IOException, InterruptedException {
		FileSplit split = (FileSplit) context.getInputSplit();  
        flag = split.getPath().getParent().getName();// 判断读的数据集  
          
        System.out.println(flag); 
	}	
}
