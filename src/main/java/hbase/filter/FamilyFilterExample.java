package hbase.filter;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.FamilyFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.util.Bytes;

public class FamilyFilterExample {

	public static void main(String[] args) throws Exception {
		
		Configuration conf = HBaseConfiguration.create();
		
		conf.set("hbase.rootdir", "hdfs://zgg:9000/user/hbase");
		conf.set("hbase.zookeeper.quorum","zgg");
		conf.set("hbase.zookeeper.property.clientPort","2181");  
		conf.set("zookeeper.znode.parent","/hbase"); 

		Connection connection = ConnectionFactory.createConnection(conf);
		Table table = connection.getTable(TableName.valueOf("table1"));
		
		Filter filter = new FamilyFilter(CompareFilter.CompareOp.EQUAL, 
			      new SubstringComparator("info"));

		Scan scan = new Scan();
		scan.setFilter(filter);
		ResultScanner scanner = table.getScanner(scan); 
			    
		System.out.println("Scanning table... ");
			   
		for (Result result : scanner) {
			 System.out.println(result);
		}
		scanner.close();

		Get get = new Get(Bytes.toBytes("1"));//指定获取第一行的info列族的内容
		get.setFilter(filter);
		Result result1 = table.get(get);
		System.out.println("Result of get(): " + result1);
	}
}
