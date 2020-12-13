package hbase.filter;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.util.Bytes;

public class RowFilterExample {

	public static void main(String[] args) throws Exception {
		
		Configuration conf = HBaseConfiguration.create();
		
		conf.set("hbase.rootdir", "hdfs://zgg:9000/user/hbase");
		conf.set("hbase.zookeeper.quorum","zgg");
		conf.set("hbase.zookeeper.property.clientPort","2181");  
		conf.set("zookeeper.znode.parent","/hbase"); 

		Connection connection = ConnectionFactory.createConnection(conf);
		Table table = connection.getTable(TableName.valueOf("table1"));
		
		Scan scan = new Scan();
	    scan.addColumn(Bytes.toBytes("prof"), Bytes.toBytes("salary"));
	    
	    Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL,new SubstringComparator("2"));	    		
	    		
	    scan.setFilter(filter);
	    ResultScanner scanner = table.getScanner(scan);
	    System.out.println("Scanning table #1...");
	
	    for (Result res : scanner) {
	      System.out.println(res);
	    }
	    scanner.close();
	}

}
