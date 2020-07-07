package hadoopbase.combine;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.net.URI;

public class combine02 {

	private static final String INPUT_PATH = "hdfs://zgg:9000/in/combinedata2.txt";
	private static final String OUT_PATH = "hdfs://zgg:9000/out/combine";
	
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		final FileSystem fileSystem = FileSystem.get(new URI(INPUT_PATH), conf);
		final Path outPath = new Path(OUT_PATH);
		if(fileSystem.exists(outPath)){
			fileSystem.delete(outPath, true);
		}
		
		final Job job = new Job(conf , combine02.class.getSimpleName());
		job.setJarByClass(combine02.class);
		//1.1指定读取的文件位于哪里
		FileInputFormat.setInputPaths(job, INPUT_PATH);
		//指定如何对输入文件进行格式化，把输入文件每一行解析成键值对
		//job.setInputFormatClass(TextInputFormat.class);
		
		//1.2 指定自定义的map类
		job.setMapperClass(MyMapper.class);
		//map输出的<k,v>类型。如果<k3,v3>的类型与<k2,v2>类型一致，则可以省略
		//job.setMapOutputKeyClass(Text.class);
		//job.setMapOutputValueClass(LongWritable.class);
		
		//1.3 分区
		job.setPartitionerClass(MyPartitioner.class);
		//有一个reduce任务运行
		job.setNumReduceTasks(2);
		
		//1.4 TODO 排序、分组
		
		//1.5 规约
		job.setCombinerClass(MyCombiner.class);
		
		//2.2 指定自定义reduce类
		job.setReducerClass(MyReducer.class);
		//指定reduce的输出类型
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		
		//2.3 指定写出到哪里
		FileOutputFormat.setOutputPath(job, outPath);
		//指定输出文件的格式化类
		//job.setOutputFormatClass(TextOutputFormat.class);
		
		//把job提交给JobTracker运行
		job.waitForCompletion(true);
	}
	
	static class MyPartitioner extends Partitioner<Text, LongWritable>{
		@Override
		public int getPartition(Text key, LongWritable value, int numReduceTasks) {
			return (key.toString().equals("hello"))?0:1;
		}
	}
	
	/**
	 * KEYIN	即k1		表示行的偏移量
	 * VALUEIN	即v1		表示行文本内容
	 * KEYOUT	即k2		表示行中出现的单词
	 * VALUEOUT	即v2		表示行中出现的单词的次数，固定值1
	 */
	static class MyMapper extends Mapper<LongWritable, Text, Text, LongWritable>{
		protected void map(LongWritable k1, Text v1, Context context) throws java.io.IOException ,InterruptedException {
			final String[] splited = v1.toString().split("\t");
			for (String word : splited) {
				context.write(new Text(word), new LongWritable(1));
				System.out.println("Mapper输出<"+word+","+1+">");
			}
		};
	}
	
	/**
	 * KEYIN	即k2		表示行中出现的单词
	 * VALUEIN	即v2		表示行中出现的单词的次数
	 * KEYOUT	即k3		表示文本中出现的不同单词
	 * VALUEOUT	即v3		表示文本中出现的不同单词的总次数
	 *
	 */
	static class MyReducer extends Reducer<Text, LongWritable, Text, LongWritable>{
		protected void reduce(Text k2, Iterable<LongWritable> v2s, Context ctx) throws java.io.IOException ,InterruptedException {
			//显示次数表示redcue函数被调用了多少次，表示k2有多少个分组
			System.out.println("MyReducer输入分组<"+k2.toString()+",...>");
			long times = 0L;
			for (LongWritable count : v2s) {
				times += count.get();
				//显示次数表示输入的k2,v2的键值对数量
				System.out.println("MyReducer输入键值对<"+k2.toString()+","+count.get()+">");
			}
			ctx.write(k2, new LongWritable(times));
		};
	}


	static class MyCombiner extends Reducer<Text, LongWritable, Text, LongWritable>{
		protected void reduce(Text k2, Iterable<LongWritable> v2s, Context ctx) throws java.io.IOException ,InterruptedException {
			//显示次数表示redcue函数被调用了多少次，表示k2有多少个分组
			System.out.println("Combiner输入分组<"+k2.toString()+",...>");
			long times = 0L;
			for (LongWritable count : v2s) {
				times += count.get();
				//显示次数表示输入的k2,v2的键值对数量
				System.out.println("Combiner输入键值对<"+k2.toString()+","+count.get()+">");
			}
			
			ctx.write(k2, new LongWritable(times));
			//显示次数表示输出的k2,v2的键值对数量
			System.out.println("Combiner输出键值对<"+k2.toString()+","+times+">");
		};
	}
}
