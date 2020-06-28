package bigdatacase.airbnb_analysis;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
/*
 * 将两个calendar表合并成一个表
 * 
 * 输出：id price   
 * */
public class CalMapper extends Mapper<Object,Text,Text,Text> {

	private String flag; 
	private final static Text k = new Text();
	
	@Override
	protected void setup(Context context) throws IOException, InterruptedException {
		FileSplit split = (FileSplit) context.getInputSplit();  
        flag = split.getPath().getName();// 判断读的数据集  
	}

	@Override
	protected void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {
		
		String[] splited = value.toString().split(",");
		
		if(splited[0].equals("listing_id")){
			return;
		}
		
		if(splited.length==4 && !splited[3].isEmpty()){
			
			if(flag.equals("calendar.csv")){
				k.set(splited[0]+"\t"+splited[3]);
				context.write(k, new Text(""));
			}	
			else if(flag.equals("calendar (1).csv")){
				k.set(splited[0]+"\t"+splited[3]);
				context.write(k, new Text(""));
		   }
			else if(flag.equals("calendar (2).csv")){
				k.set(splited[0]+"\t"+splited[3]);
				context.write(k, new Text(""));
		   }
			else if(flag.equals("calendar (3).csv")){
				k.set(splited[0]+"\t"+splited[3]);
				context.write(k, new Text(""));
		   }
			else if(flag.equals("calendar (4).csv")){
				k.set(splited[0]+"\t"+splited[3]);
				context.write(k, new Text(""));
		   }
			else if(flag.equals("calendar (5).csv")){
				k.set(splited[0]+"\t"+splited[3]);
				context.write(k, new Text(""));
		   }
			else if(flag.equals("calendar (6).csv")){
				k.set(splited[0]+"\t"+splited[3]);
				context.write(k, new Text(""));
		   }
			else if(flag.equals("calendar (7).csv")){
				k.set(splited[0]+"\t"+splited[3]);
				context.write(k, new Text(""));
		   }
			else if(flag.equals("calendar (8).csv")){
				k.set(splited[0]+"\t"+splited[3]);
				context.write(k, new Text(""));
		   }
		}				
	}
}
