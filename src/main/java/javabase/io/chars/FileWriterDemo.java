package javabase.io.chars;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[] args) throws IOException {

        //FileWriter fw = new FileWriter(new File("fw.txt"));
        FileWriter fw = new FileWriter("fw.txt");

        // 只测试写入一个字符串
        // 文件内容：fw-demo1 fw-demo2 append
        fw.write("fw-demo1");  //写入
        fw.write(" fw-demo2");
        fw.append(" append");   //追加

        fw.close();
    }
}
