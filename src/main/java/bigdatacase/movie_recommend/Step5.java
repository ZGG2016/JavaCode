package bigdatacase.movie_recommend;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public class Step5 {

    private final static Pattern DELIMITER = Pattern.compile("[\t,]");
    private static final String input_path1 = "hdfs://zgg:9000/output/recommend/step3-output";
    private static final String input_path2 = "hdfs://zgg:9000/output/recommend/step4-output";
    private static final String output_path = "hdfs://zgg:9000/output/recommend/step5-output";

    public static class Step5Mapper extends Mapper<LongWritable, Text, Text, Text> {
        /*
         * map输入：step3-output:<userID1  userID2,similarity,userID3,similarity>
         *         step4-output:<movieID,userID,pref>
         *    输出：<movieID A:userID1,userID2,userID3>
         * 			<movieID B:userID,pref>
         *
         * */

        private String flag;
        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {

            String[] splited = DELIMITER.split(value.toString());

            if (flag.equals("step3-output")) {
                for (int i = 1; i <= 1682; i++){
                    Text k = new Text(Integer.toString(i));//movieID
                    Text v = new Text("A:" + splited[0] + "," + splited[1] + "," + splited[3]); // userID1,userID2,userID3
                    context.write(k, v);
                }
            } else if (flag.equals("step4-output")) {
                Text k = new Text(splited[0]);//movieID
                Text v = new Text("B:" + splited[1] + "," + splited[2]);//userID,pref
                context.write(k, v);
            }
        }

        @Override
        protected void setup(Mapper<LongWritable, Text, Text, Text>.Context context)
                throws IOException, InterruptedException {

            FileSplit split = (FileSplit) context.getInputSplit();
            flag = split.getPath().getParent().getName();// 判断读的数据集

            //System.out.println(flag);
        }
    }

    public static class Step5Reducer extends Reducer<Text, Text, Text, Text> {
        /*
         * reduce:输入：<movieID A:userID1,userID2,userID3>
         * 			    <movieID B:userID,pref>
         *        输出：<userID  movieID,average pref>
         *
         * */
        private final static Text k = new Text();
        private final static Text v = new Text();
        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context)
                throws IOException, InterruptedException {

            Map<String, String> mapA = new HashMap<String, String>();
            Map<String, String> mapB = new HashMap<String, String>();

            for (Text value : values) {
                String val = value.toString();

                if (val.startsWith("A:")) {
                    String[] kv = DELIMITER.split(val.substring(2));
                    mapA.put(kv[0], kv[1] + "," + kv[2]);  //userID1  userID2,userID3
                } else if (val.startsWith("B:")) {
                    String[] kv = DELIMITER.split(val.substring(2));
                    mapB.put(kv[0], kv[1]);  //userID,pref
                }
            }
            //mapA：userID1	userID2,userID3（和用户1相似的两个用户）
            //mapB：userID	pref
            Iterator<String> iterA = mapA.keySet().iterator();
            while (iterA.hasNext())
            {
                String userId = iterA.next();
                //mapB包含userID说明，userID看过这部电影
                if (!mapB.containsKey(userId))//不存在可以推荐 看过这部电影，不推荐
                {
                    String simiStr = mapA.get(userId);  //simiStr---userID2,userID3
                    String[] simi =DELIMITER.split(simiStr);
                    if (simi.length >= 2)
                    {
                        //pref
                        //取出userID2,userID3的pref
                        double simiVal1 = mapB.containsKey(simi[0]) ? Double.parseDouble(mapB.get(simi[0])) : 0;
                        double simiVal2 = mapB.containsKey(simi[1]) ? Double.parseDouble(mapB.get(simi[1])) : 0;
                        double score = (simiVal1 + simiVal2) / 2;
                        k.set(userId);  //userId对key的预测评分
                        v.set(key.toString() + "," + String.format("%.2f", score));
                        context.write(k,v);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BasicConfigurator.configure();
        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf);

        job.setJarByClass(Step5.class);

        job.setMapperClass(Step5Mapper.class);
        job.setReducerClass(Step5Reducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        Path path = new Path(output_path);
        FileSystem fs =path.getFileSystem(conf);
        if(fs.exists(path)){
            fs.delete(path,true);
        }

        FileInputFormat.setInputPaths(job, new Path(input_path1),new Path(input_path2));
        FileOutputFormat.setOutputPath(job, path);

        boolean res = job.waitForCompletion(true);

        System.exit(res?0:1);
    }
}
