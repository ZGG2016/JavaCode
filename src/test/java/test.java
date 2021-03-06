
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.VIntWritable;
import org.apache.hadoop.mapred.SkipBadRecords;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.v2.app.speculate.DefaultSpeculator;
import org.apache.hadoop.mapreduce.v2.app.speculate.Speculator;
import org.apache.hadoop.service.AbstractService;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.net.URI;
import java.util.Comparator;
import java.util.PriorityQueue;

public class test {

    public static void main(String[] args) throws Exception {

        String s1 = new String("aaa");
        String s2 = new String("aaa");

        System.out.println(s1==s2); //false
        boolean f = s1.equals(s2);
        System.out.println(f); //true

        Integer c = 100;
        Integer d = 100;
        System.out.println(c==d); //true
        System.out.println(c.equals(d));  //true

        c = 200;
        d = 200;
        System.out.println(c instanceof Integer);
        System.out.println(c==d); //false
        System.out.println(c.equals(d));  //true

    }



}