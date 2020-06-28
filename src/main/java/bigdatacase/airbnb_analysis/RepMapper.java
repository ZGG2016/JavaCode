package bigdatacase.airbnb_analysis;

import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

public class RepMapper extends Mapper<Object,Text,Text,Text> {

	private String flag; 
	private final static Text k = new Text();
	private final static Text v = new Text();
	private static final Pattern DELIMITER = Pattern.compile("[\t,]");
	
	@Override
	protected void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {

		String[] splited = DELIMITER.split(value.toString());
			
			if(flag.equals("listoutput")){
				k.set(splited[0]);
				v.set("A:"+splited[1]+","+splited[2]+","+splited[3]+","+splited[4]);
				context.write(k, v);
			}	
			else if(flag.equals("caloutput")){
				k.set(splited[0]);
				v.set("B:"+splited[1]);
				context.write(k, v);
		   }	

	}

	@Override
	protected void setup(Context context) throws IOException, InterruptedException {
		FileSplit split = (FileSplit) context.getInputSplit();  
        flag = split.getPath().getParent().getName();// 判断读的数据集  
	}

}
