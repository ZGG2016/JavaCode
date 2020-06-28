package bigdatacase.airbnb_analysis;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
/*
 * 将key相同的行删掉
 * 
 * */
public class CalReducer extends Reducer<Text,Text, Text,Text> {
	
	@Override
	protected void reduce(Text key, Iterable<Text> vals,Context context) throws IOException, InterruptedException {
	
		context.write(key, new Text(""));
		
	}

}
