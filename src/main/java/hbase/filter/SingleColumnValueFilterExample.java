package hbase.filter;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
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
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.util.Bytes;

public class SingleColumnValueFilterExample {

	public static void main(String[] args) throws Exception {
		
		Configuration conf = HBaseConfiguration.create();
		
		conf.set("hbase.rootdir", "hdfs://zgg:9000/user/hbase");
		conf.set("hbase.zookeeper.quorum","zgg");
		conf.set("hbase.zookeeper.property.clientPort","2181");  
		conf.set("zookeeper.znode.parent","/hbase"); 

		Connection connection = ConnectionFactory.createConnection(conf);
		Table table = connection.getTable(TableName.valueOf("table1"));
		
		SingleColumnValueFilter filter = new SingleColumnValueFilter(
			      Bytes.toBytes("prof"),
			      Bytes.toBytes("salary"),
			      CompareFilter.CompareOp.EQUAL,
			      new SubstringComparator("2000"));
	    filter.setFilterIfMissing(true);  //判断如果没有找到对应的列，是否过滤掉整行
	    Scan scan = new Scan();
	    scan.setFilter(filter);
	    ResultScanner scanner = table.getScanner(scan);	
	    System.out.println("Results of scan:");
	    for (Result result : scanner) {
	        for (Cell cell : result.rawCells()) {
	          System.out.println("Cell: " + cell + ", Value: " +
	            Bytes.toString(cell.getValueArray(), cell.getValueOffset(),
	              cell.getValueLength()));
	        }
	    }
	    
	    scanner.close();

	    Get get = new Get(Bytes.toBytes("1"));
	    get.setFilter(filter);
	    Result result = table.get(get);
	    System.out.println("Result of get: ");
	    for (Cell cell : result.rawCells()) {
	      System.out.println("Cell: " + cell + ", Value: " +
	        Bytes.toString(cell.getValueArray(), cell.getValueOffset(),
	          cell.getValueLength()));
	    }
	}

}
