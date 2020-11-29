package spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WordCount {
    private static final Pattern SPACE = Pattern.compile(" ");

    public static void main(String[] args) {

        SparkConf conf = new SparkConf().setAppName("wordcount").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);

//        JavaRDD<String> lines = sc.textFile(args[0]);
        JavaRDD<String> lines = sc.textFile("src/main/resources/bos.txt");
        JavaRDD<String> words = lines.flatMap(s -> Arrays.asList(SPACE.split(s)).iterator());

        JavaPairRDD<String, Integer> ones = words.mapToPair(s -> new Tuple2<>(s, 1));

        JavaPairRDD<String, Integer> counts = ones.reduceByKey((i1, i2) -> i1 + i2);

        List<Tuple2<String, Integer>> output = counts.collect();
        for (Tuple2<?,?> tuple : output) {
            System.out.println(tuple._1() + ": " + tuple._2());
        }
        sc.stop();
    }
}
/*
* standalone集群运行：
*   spark-submit --class spark.wordcount --master spark://zgg:7077  wc.jar hdfs://zgg:9000/in/wc.txt
*
* */