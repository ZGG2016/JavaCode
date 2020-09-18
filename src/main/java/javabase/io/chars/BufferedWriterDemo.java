package javabase.io.chars;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException{

        //1、构造方法

        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
        // new FileOutputStream("bw.txt")));
        BufferedWriter bw = new BufferedWriter(new FileWriter("bw.txt"));

        //2、成员方法

        bw.write('a'); //写一个字符

        char[] chs = {'a','b','c','d','e'};
        bw.write(chs); //写一个字符数组  ， 父类方法
        bw.write(chs,1,3); //写一个字符数组的一部分

        bw.write("我爱林青霞"); // 写一个字符串  ， 父类方法
        bw.write("我爱林青霞", 2, 3); // 写一个字符串的一部分

        bw.append('z'); //追加一个字符 ， 父类方法
        bw.append("追加示例"); //追加一个字符序列 ， 父类方法
        bw.append("追加示例",0,2); //追加一个字符序列的一部分 ， 父类方法

        for (int x = 0; x < 10; x++) {
            bw.write("hello" + x);
            // bw.write("\r\n");
            bw.newLine();
            //bw.flush();
        }

        bw.close();
    }
}
