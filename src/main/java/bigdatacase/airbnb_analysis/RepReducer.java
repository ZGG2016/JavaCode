package bigdatacase.airbnb_analysis;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class RepReducer extends Reducer<Text,Text,LongWritable,Text> {

	private final static LongWritable k = new LongWritable();
	private final static Text v = new Text();
	
	@Override
	protected void reduce(Text key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {
		
		Map<String, String> mapA = new HashMap<String, String>();  
        Map<String, String> mapB = new HashMap<String, String>();  
        
        for (Text value : values) {  
            String val = value.toString(); 
            if (val.startsWith("A:")){
            	String[] splited1 = val.substring(2).split(",");
            	// id    名字 经纬度  sum
            	mapA.put(key.toString(),splited1[0]+","+splited1[1]+","+splited1[2]+","+splited1[3]);
            }else if(val.startsWith("B:")){
            	String price = val.substring(2);           	
            	mapB.put(key.toString(),price); //  id 价钱
            }
       }
        
        
        Iterator<String> iterB = mapB.keySet().iterator();  
        while (iterB.hasNext()) {
        	 String calid = iterB.next();        	
        	 Iterator<String> iterA = mapA.keySet().iterator();  
        	 while (iterA.hasNext()){
        		 String listid = iterA.next();
        		 if(calid.equals(listid)){
        			 String str = mapA.get(listid);  //名字 经纬度  sum
        			 String[] token = str.split(",");       			
        			         k.set(Long.parseLong(listid));
        			         v.set(token[0]+"\t"+token[1]+"\t"+token[2]+"\t"+token[3]+"\t"+mapB.get(listid));	           			
	            			 context.write(k, v);

        			 }
        		    	
            }
       	         	 
        }		
	}	
	
}
