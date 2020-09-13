import hadoopbase.compress.FileDecompressor;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionOutputStream;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.mapred.LineRecordReader;
import org.apache.hadoop.util.ReflectionUtils;
import org.apache.hadoop.util.StringUtils;
import org.apache.log4j.BasicConfigurator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class test {

    public static int aMethod(int i) throws Exception {

        try {
            return i/10;
        }catch (Exception ex){
            throw new Exception("exception in a Method");
        }finally {
            System.out.println("finally");
        }
    }



    public static void main(String[] args) throws Exception {
        try{
            aMethod(0);
        }catch (Exception ex){
            System.out.println("exception in main");
        }
        System.out.println("finished");
    }

}
