package bigdatacase.ipaddr_analysis;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.redis.bolt.RedisStoreBolt;
import org.apache.storm.redis.common.config.JedisPoolConfig;
import org.apache.storm.redis.common.mapper.RedisDataTypeDescription;
import org.apache.storm.redis.common.mapper.RedisStoreMapper;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.ITuple;

public class IPTopology {
    public static void main(String[] args) {

        String host = "192.168.0.104";
        int port = 6379;

        JedisPoolConfig poolConfig = new JedisPoolConfig.Builder()
                .setHost(host).setPort(port).build();

        RedisStoreMapper storeMapper = setupStoreMapper();
        RedisStoreBolt storeBolt = new RedisStoreBolt(poolConfig, storeMapper);

        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("kafka", new KafkaSpout("iptopic"));
        builder.setBolt("prebolt", new PreBolt()).shuffleGrouping("kafka");
        builder.setBolt("findbolt", new FindBolt()).shuffleGrouping("prebolt");
        builder.setBolt("storebolt", storeBolt, 1).shuffleGrouping("findbolt");

        Config config = new Config();
        config.setDebug(true);
        //config.put(Config.TOPOLOGY_MAX_SPOUT_PENDING, 2048);
        config.put(Config.TOPOLOGY_BACKPRESSURE_ENABLE, false);
        config.put(Config.TOPOLOGY_EXECUTOR_RECEIVE_BUFFER_SIZE, 16384);
        config.put(Config.TOPOLOGY_EXECUTOR_SEND_BUFFER_SIZE, 16384);

        LocalCluster local = new LocalCluster();
        local.submitTopology("ip", config, builder.createTopology());

    }

    private static RedisStoreMapper setupStoreMapper() {
        return new IpStoreMapper();
    }

    private static class IpStoreMapper implements RedisStoreMapper {
        private RedisDataTypeDescription description;

        public IpStoreMapper() {
            description = new RedisDataTypeDescription(
                    RedisDataTypeDescription.RedisDataType.STRING);
        }

        public RedisDataTypeDescription getDataTypeDescription() {
            return description;
        }

        public String getKeyFromTuple(ITuple iTuple) {
            return iTuple.getStringByField("ip");
        }

        public String getValueFromTuple(ITuple iTuple) {
            return iTuple.getStringByField("lonandlatandcity");
        }

    }
}
