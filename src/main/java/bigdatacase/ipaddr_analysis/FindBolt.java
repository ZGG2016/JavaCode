package bigdatacase.ipaddr_analysis;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbMakerConfigException;
import org.lionsoul.ip2region.DbSearcher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class FindBolt implements IRichBolt {

    private static final Pattern DELIMITER = Pattern.compile("[|]");
    OutputCollector collector;

    @Override
    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
        this.collector = collector;
    }

    @Override
    public void execute(Tuple input) {
        //创建查询对象
        DbConfig config = null;
        try {
            config = new DbConfig();
            DbSearcher seacher = new DbSearcher(config, "G:\\ip2region-1.2.4-release\\data\\ip2region.db");
            DataBlock ret = seacher.btreeSearch(input.getString(0));
            String str = ret.getRegion();

            String[] splited = DELIMITER.split(str.toString());
            if(str.startsWith("中国")){

            String[] ll = IpToLL.getIPXY(input.getString(0));  //ip获取经纬度
            String longitude = ll[0]; //经度
            String latitude = ll[1]; //纬度

            String lonandlatandcity = longitude+","+latitude+","+splited[3];

                this.collector.emit(new Values(input.getString(0),lonandlatandcity));
            }
            //项目关闭时，关闭searcher对象
            seacher.close();
        } catch (DbMakerConfigException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void cleanup() {

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

        declarer.declare(new Fields("ip","lonandlatandcity"));
    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }
}
