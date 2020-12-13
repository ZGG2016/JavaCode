package hbase.filter;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.KeyOnlyFilter;
import org.apache.hadoop.hbase.util.Bytes;

public class KeyOnlyFilterExample {

	public static void main(String[] args) throws Exception {
		
		Configuration conf = HBaseConfiguration.create();
		
		conf.set("hbase.rootdir", "hdfs://zgg:9000/user/hbase");
		conf.set("hbase.zookeeper.quorum","zgg");
		conf.set("hbase.zookeeper.property.clientPort","2181");  
		conf.set("zookeeper.znode.parent","/hbase"); 

		Connection connection = ConnectionFactory.createConnection(conf);
		Table table = connection.getTable(TableName.valueOf("table1"));
				       
        KeyOnlyFilter filter=new KeyOnlyFilter();  
        Scan scan=new Scan();  
        scan.setFilter(filter);  
                 
        ResultScanner scanner=table.getScanner(scan);  
        System.out.println("Results of scan:");
	    for (Result result : scanner){  
                       
            KeyValue[] kvs= (KeyValue[]) result.rawCells();
            for(KeyValue kv:kvs)  
            {  
                System.out.println(kv.toString());  
                System.out.println(Bytes.toString(kv.getValueArray()));
            }  
        }          
	    scanner.close();  
        table.close();  
	}
}
