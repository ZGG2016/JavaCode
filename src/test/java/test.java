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

    public static void main(String[] args) throws Exception {

        HashMap<Integer, String> hm = new HashMap<Integer, String>();

        LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();

        TreeMap<String, String> tm = new TreeMap<String, String>();

        Hashtable<String, Integer> numbers = new Hashtable<String, Integer>();

        for(int i=0;i<5;i++){
            System.out.println(i);
        }

        for(int i=0;i<5;++i){
            System.out.println(i);
        }
    }


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
