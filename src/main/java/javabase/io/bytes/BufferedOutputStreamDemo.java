package javabase.io.bytes;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamDemo {
    public static void main(String[] args) throws IOException {

        // 1.构造方法
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("bos.txt"));
//        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("bos.txt"),1);


        //2.成员方法

        //写一个字节
        bos.write(97);
        bos.write("\r\n".getBytes());  //数据的换行

        byte[] bys={97,98,99,100,101};

        //写一个字节数组
        bos.write(bys);   //父类方法
        bos.write(("hello").getBytes());
        bos.write("\r\n".getBytes());

        //写一个字节数组的一部分
        bos.write(bys,1,3);
        bos.write("hello".getBytes(),0,3);
        bos.write("\r\n".getBytes());

        //bos.flush();

        bos.close();

    }
}
