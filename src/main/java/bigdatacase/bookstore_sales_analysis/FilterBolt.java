package bigdatacase.bookstore_sales_analysis;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.Map;

public class FilterBolt implements IRichBolt {

    OutputCollector collector = null;

    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
        this.collector = collector;
    }

    public void execute(Tuple input) {
        String order = input.getString(0);
        // 订单号，销售额，时间，消费者
        // 1,50,Wed Nov 01 11:14:34 CST 2017,a
        String splited[] = order.split(",");
        String amt = splited[1];   //销售额
        String date = splited[2].substring(4,10);  //日期

        this.collector.emit(new Values(date,amt));
    }

    public void cleanup() {

    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {

        declarer.declare(new Fields("date","amt"));
    }

    public Map<String, Object> getComponentConfiguration() {
        return null;
    }
}
