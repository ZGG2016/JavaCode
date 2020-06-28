package bigdatacase.airbnb_analysis;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
/*
 * 数据预处理
 * 
 * 输出：id   name,latitude,longitude,number_of_reviews
 * 
 * */
public class ListMapper extends Mapper<Object,Text,LongWritable,Text> {

	private String flag; 
	private final static LongWritable k = new LongWritable();
	private final static Text v = new Text();
	
	
	@Override
	protected void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {
		
		String[] splited = value.toString().split(",");
		
		if(splited[0].equals("id")){
			return;
		}
		
		if(splited.length == 16 && !splited[6].isEmpty() && !splited[7].isEmpty() && !splited[11].isEmpty()){						
			
			 if (flag.equals("listings.csv")){
				 k.set(Long.parseLong(splited[0]));
				 v.set(splited[1]+","+splited[6]+","+splited[7]+","+splited[11]);
				 context.write(k, v);
			 }
			 else if (flag.equals("listings (1).csv")){
				 k.set(Long.parseLong(splited[0]));
				 v.set(splited[1]+","+splited[6]+","+splited[7]+","+splited[11]);
				 context.write(k, v);
			 }
			 else if (flag.equals("listings（2）.csv")){
				 k.set(Long.parseLong(splited[0]));
				 v.set(splited[1]+","+splited[6]+","+splited[7]+","+splited[11]);
				 context.write(k, v);
			 }
			 else if (flag.equals("listings（3）.csv")){
				 k.set(Long.parseLong(splited[0]));
				 v.set(splited[1]+","+splited[6]+","+splited[7]+","+splited[11]);
				 context.write(k, v);
			 }
			 else if (flag.equals("listings（4）.csv")){
				 k.set(Long.parseLong(splited[0]));
				 v.set(splited[1]+","+splited[6]+","+splited[7]+","+splited[11]);
				 context.write(k, v);
			 }
			 else if (flag.equals("listings（5）.csv")){
				 k.set(Long.parseLong(splited[0]));
				 v.set(splited[1]+","+splited[6]+","+splited[7]+","+splited[11]);
				 context.write(k, v);
			 }
			 else if (flag.equals("listings（6）.csv")){
				 k.set(Long.parseLong(splited[0]));
				 v.set(splited[1]+","+splited[6]+","+splited[7]+","+splited[11]);
				 context.write(k, v);
			 }
			 else if (flag.equals("listings（7）.csv")){
				 k.set(Long.parseLong(splited[0]));
				 v.set(splited[1]+","+splited[6]+","+splited[7]+","+splited[11]);
				 context.write(k, v);
			 }
			 else if (flag.equals("listings（8）.csv")){
				 k.set(Long.parseLong(splited[0]));
				 v.set(splited[1]+","+splited[6]+","+splited[7]+","+splited[11]);
				 context.write(k, v);
			 }
			
		}
		
	}

	@Override
	protected void setup(Context context)
			throws IOException, InterruptedException {
		
		FileSplit split = (FileSplit) context.getInputSplit();  
        flag = split.getPath().getName();// 判断读的数据集  
          
       // System.out.println(flag);
	}		
}
