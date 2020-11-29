
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.VIntWritable;
import org.apache.hadoop.mapred.SkipBadRecords;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.net.URI;
import java.util.Comparator;
import java.util.PriorityQueue;

public class test {

    public static void main(String[] args) throws Exception {

//        PriorityQueue<Integer> maxHeap =
//                new PriorityQueue<>(11, new Comparator<Integer>() {
//                    @Override
//                    public int compare(Integer o1, Integer o2) {
//                        return o2-o1;
//                    }
//                });
//
//        maxHeap.add(2);
//        maxHeap.add(4);
//        maxHeap.add(3);
//
//        for(Integer a:maxHeap){
//            System.out.println(a);
//
//        }
//
//        System.out.println(maxHeap.peek());

    }


}