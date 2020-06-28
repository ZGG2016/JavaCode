package bigdatacase.bookstore_sales_analysis;

import kafka.api.OffsetRequest;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.kafka.*;
import org.apache.storm.redis.bolt.RedisStoreBolt;
import org.apache.storm.spout.SchemeAsMultiScheme;
import org.apache.storm.redis.common.config.JedisPoolConfig;
import org.apache.storm.redis.common.mapper.RedisDataTypeDescription;
import org.apache.storm.redis.common.mapper.RedisStoreMapper;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.ITuple;

public class BSTopology {
    public static void main(String[] args){

        //配置kafkaspout
        String zks = "datanode1:2181,datanode2:2181,datanode3:2181";
        String topic = "sale";
        String id = "group1";

        ZkHosts brokerHosts = new ZkHosts(zks);
        SpoutConfig spoutconfig = new SpoutConfig(brokerHosts,topic,"",id);
        spoutconfig.scheme = new SchemeAsMultiScheme(new StringScheme());
        spoutconfig.startOffsetTime = OffsetRequest.LatestTime();
        KafkaSpout kafkaSpout = new KafkaSpout(spoutconfig);

        Config config = new Config();

        //连接redis服务
        JedisPoolConfig poolConfig = new JedisPoolConfig.Builder()
                .setHost("192.168.0.9").setPort(6379).build();

        RedisStoreMapper storeMapper = setupStoreMapper();
        RedisStoreBolt storeBolt = new RedisStoreBolt(poolConfig, storeMapper);

        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("spout",kafkaSpout,1);
        builder.setBolt("FilterBolt",new FilterBolt(),1).shuffleGrouping("spout");
        builder.setBolt("ComputeBolt",new ComputeBolt(),1).shuffleGrouping("FilterBolt");
        builder.setBolt("storeBolt",storeBolt,1).fieldsGrouping("ComputeBolt",new Fields("date"));

        config.setNumWorkers(3);

        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology(BSTopology.class.getSimpleName(), config, builder.createTopology());

    }

    //storm集成redis
    private static RedisStoreMapper setupStoreMapper() {
        return new BookStoreMapper();
    }

    private static class BookStoreMapper implements RedisStoreMapper {

        private RedisDataTypeDescription description ;

        public  BookStoreMapper(){
            description = new RedisDataTypeDescription(
                    RedisDataTypeDescription.RedisDataType.STRING);
        }

        @Override
        public RedisDataTypeDescription getDataTypeDescription() {
            return description ;
        }

        @Override
        public String getKeyFromTuple(ITuple iTuple) {
            return iTuple.getStringByField("date");
        }

        @Override
        public String getValueFromTuple(ITuple iTuple) {
            String value = iTuple.getStringByField("day_amt")+"-"+iTuple.getStringByField("month_amt");

            return value;
        }

    }

}
