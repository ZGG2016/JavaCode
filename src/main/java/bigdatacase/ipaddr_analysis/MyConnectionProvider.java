//package bigdatacase.ipaddr_analysis;
//
//import org.apache.storm.jdbc.common.ConnectionProvider;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class MyConnectionProvider implements ConnectionProvider {
//
//
//    private static String driver = "com.mysql.jdbc.driver";
//    private static String url = "jdbc:mysql://192.168.0.104:3306/new_databasename";  //数据库名称
//    private static String user = "root";
//    private static String password = "root";
//
//
//    static{
//
//        try {
//            Class.forName(driver);
//        } catch (ClassNotFoundException e) {
//            new ExceptionInInitializerError(e);
//        }
//
//    }
//
//    @Override
//    public void prepare() {
//
//    }
//
//    @Override
//    public Connection getConnection() {
//        try {
//            return DriverManager.getConnection(url,user,password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public void cleanup() {
//
//    }
//}
