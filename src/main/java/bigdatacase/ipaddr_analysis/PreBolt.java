package bigdatacase.ipaddr_analysis;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.Map;
import java.util.regex.Pattern;

public class PreBolt implements IRichBolt {

    private static final Pattern DELIMITER = Pattern.compile("[| ]");
    OutputCollector collector;

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.collector = collector;
    }

    public void execute(Tuple tuple) {
        String PatternIP = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."

                +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."

                +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."

                +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

        String line = tuple.getString(0);
        if(line.contains("[INFO]")){
            String[] splited = DELIMITER.split(line.toString());
            for(int i=0; i< splited.length ; i++){
               if(splited[i].matches(PatternIP)){
                    //System.out.println(splited[i]);
                    this.collector.emit(new Values(splited[i],1));
                }
            }
        }

        this.collector.ack(tuple);
    }

    public void cleanup() {

    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("ip","num"));
    }

    public Map<String, Object> getComponentConfiguration() {
        return null;
    }

}
