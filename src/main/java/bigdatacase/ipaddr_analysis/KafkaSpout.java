package bigdatacase.ipaddr_analysis;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichSpout;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class KafkaSpout implements IRichSpout {

    SpoutOutputCollector collector;
    private ConsumerConnector consumer;
    private String topic;

    public KafkaSpout(String topic) {
        this.topic = topic;
    }

    private static ConsumerConfig createConsumerConfig() {
        Properties props = new Properties();
        //props.put("zookeeper.connect","master:2181,slaver1:2181,slaver2:2181");
        props.put("zookeeper.connect","master:2181");
        props.put("group.id","0");
        props.put("zookeeper.session.timeout.ms","10000");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");

        return new ConsumerConfig(props);
    }

    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        this.collector = collector;
    }

    public void close() {

    }

    public void activate() {
        this.consumer = Consumer.createJavaConsumerConnector(createConsumerConfig());
        Map<String, Integer> topickMap = new HashMap<String, Integer>();
        topickMap.put(topic, new Integer(1));  //topickMap的内容
        Map<String, List<KafkaStream<byte[], byte[]>>> streamMap = consumer.createMessageStreams(topickMap);
        KafkaStream<byte[], byte[]> stream = streamMap.get(topic).get(0);
        ConsumerIterator<byte[], byte[]> it = stream.iterator();
        while (it.hasNext()) {
            String value = new String(it.next().message());  //value是topic中的内容
            collector.emit(new Values(value), value);
        }
    }

    public void deactivate() {

    }

    public void nextTuple() {

    }

    public void ack(Object o) {

    }

    public void fail(Object o) {

    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("sentence"));
    }

    public Map<String, Object> getComponentConfiguration() {
        return null;
    }

}
