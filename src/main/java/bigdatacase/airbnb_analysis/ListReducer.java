package bigdatacase.airbnb_analysis;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
/*
 *设定一个阈值，大于该阈值的民宿即评为受欢迎的民宿。
 *
 *输入：id   name,latitude,longitude,number_of_reviews
 *输出：id   name,latitude,longitude, sum（各个表的number_of_reviews的和）
 * 
 * */
public class ListReducer extends Reducer<LongWritable,Text, LongWritable,Text> {

	private final static Text v = new Text();
	
	@Override
	protected void reduce(LongWritable key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {
		
		int sum = 0;
		for(Text val : values){
			String[] splited = val.toString().split(",");
			int num = Integer.parseInt(splited[3]);			
			sum+=num;	
			v.set(splited[0]+"\t"+splited[1]+"\t"+splited[2]+"\t"+String.valueOf(sum));
		}
		
		if(sum>300){
			context.write(key, v);
		}
		
	}	
}
