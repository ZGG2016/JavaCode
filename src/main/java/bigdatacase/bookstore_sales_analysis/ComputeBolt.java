package bigdatacase.bookstore_sales_analysis;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.HashMap;
import java.util.Map;

public class ComputeBolt implements IRichBolt {

    OutputCollector collector = null;

    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
        this.collector = collector;
    }

    Map<String,Double> monthMap = new HashMap<String, Double>();
    Map<String,Double> dayMap = new HashMap<String, Double>();

    public void execute(Tuple input) {

        String date = input.getStringByField("date");
        Double amt = Double.parseDouble(input.getStringByField("amt"));

        String month = date.substring(0,3);
        String day = date.substring(5,6);

        //计算每个月的销售额
        Double monthAmt = monthMap.get(month);
        if(monthAmt == null){
            monthAmt = 0.0;
        }
        monthAmt += amt;
        monthMap.put(month,monthAmt);
        //  ###############################################
        //计算每天的销售额
        Double dayAmt = dayMap.get(day);
        if(dayAmt == null){
            dayAmt = 0.0;
        }
        dayAmt +=amt;
        dayMap.put(day,dayAmt);
        this.collector.emit(new Values(date,String.valueOf(dayAmt),String.valueOf(monthAmt)));

    }

    public void cleanup() {

    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {

        declarer.declare(new Fields("date","day_amt","month_amt"));
    }

    public Map<String, Object> getComponentConfiguration() {
        return null;
    }
}
