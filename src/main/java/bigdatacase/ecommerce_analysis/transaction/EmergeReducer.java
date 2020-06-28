
package bigdatacase.ecommerce_analysis.transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
/*
 * 输入：pre: item sum   A
 * 		 part1: item 属性	  B
 * 输出：item  sum 属性
 * */
public class EmergeReducer extends Reducer<Text, Text, Text, Text> {

	private final static Text k = new Text();
	private final static Text v = new Text();
	
	@Override
	protected void reduce(Text key, Iterable<Text> values,Context context) throws IOException, InterruptedException {
		
		Map<String, String> mapA = new HashMap<String, String>();
		Map<String, String> mapB = new HashMap<String, String>();
		
		for(Text value : values){
			String str = value.toString();
			if(str.startsWith("A:")){
				mapA.put(key.toString(), str.substring(2));
			}
			else if(str.startsWith("B:")){
				mapB.put(key.toString(), str.substring(2));
			}
		}
		
		Iterator<String> itA = mapA.keySet().iterator();
		while(itA.hasNext()){
			String keyA = itA.next();
			Iterator<String> itB = mapB.keySet().iterator();
			while(itB.hasNext()){
				String keyB = itB.next();
				if(keyA.equals(keyB)){
					k.set(keyA);
					v.set(mapA.get(keyA)+"\t"+mapB.get(keyB));
					context.write(k, v);
				}
			}
		}
		
        	}
		
	}

	
	

