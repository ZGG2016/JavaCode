package bigdatacase.bookstore_sales_analysis;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class KafkaProducer {
    public static void main( String[] args ){
        //配置kafka
        Properties props = new Properties();
        props.put("bootstrap.servers", "datanode1:9092,datanode2:9092,datanode3:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        String[] order_amt = {"50","60","60","70","80"};  //消费额
        String[] user = {"a","b","c","d","e","f","g","h"};  //消费者代码

        Random random = new Random();

        Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(props);


        for(int i=0;i<1000;i++){

            try {
                Thread.sleep(5000);   //5秒钟发一次数据
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //设置时间范围
            Date randomDate = randomDate("2016-01-01", "2016-12-31");

            String message = i+","+order_amt[random.nextInt(5)]
                    +","+randomDate.toString()
                    +","+user[random.nextInt(8)];
            producer.send(new ProducerRecord<String, String>("sale", message));
            System.out.println(message);

        }
    }
    private static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);// 构造开始日期
            Date end = format.parse(endDate);// 构造结束日期
            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());

            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }
}
