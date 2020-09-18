package javabase.io.chars;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriterDemo {
    public static void main(String[] args) throws IOException {

        // 1、构造方法

        //OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("osw.txt"));
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(
         "osw.txt"), "GBK");
//        osw.write("中国");

        //2、成员方法

        //获取默认的字符编码【创建对象时没有指定】
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("osw.txt"));
//        System.out.println(osw.getEncoding());  //UTF8 依赖于编辑器设置的编码方式

        osw.write('a'); //写一个字符

        char[] chs = {'a','b','c','d','e'};
        osw.write(chs); //写一个字符数组  ， 父类方法
        osw.write(chs,1,3); //写一个字符数组的一部分

        osw.write("我爱林青霞"); // 写一个字符串  ， 父类方法
        osw.write("我爱林青霞", 2, 3); // 写一个字符串的一部分

        osw.append('z'); //追加一个字符 ， 父类方法
        osw.append("追加示例"); //追加一个字符序列 ， 父类方法
        osw.append("追加示例",0,2); //追加一个字符序列的一部分 ， 父类方法

        // 刷新缓冲区
        //osw.flush();
        // osw.write("我爱林青霞", 2, 3);  //可以写成功

        // 释放资源
        osw.close();
        // java.io.IOException: Stream closed
        // osw.write("我爱林青霞", 2, 3);  //报错

        //3、flush()和close()的作用

        // 执行如下语句，内容并不会写入到文件。因为，内容并不是直接写入到文件，而是先进入缓冲区，
        // 经过flush()或close()后，才写入到文件。
//        osw.write('a');
    }
}
