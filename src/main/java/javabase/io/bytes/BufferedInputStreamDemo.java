package javabase.io.bytes;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamDemo {
    public static void main(String[] args) throws IOException {

        // 1.构造方法

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
                "bos.txt"));
//        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
//                "bos.txt"),2);

        // 2.成员方法的基本使用

        //返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取（或跳过）的估计剩余字节数。
//        System.out.println(bis.available()); //23
//
//        int n1 = bis.read();  // 一次读取一个字节
//        System.out.println("读的字节："+n1);  //97
//        System.out.println("读的字节为："+(char)n1);  //a
//
//        //跳过和丢弃此输入流中数据的 n 个字节
//        //传入要跳过的字符数 ，返回实际跳过的字符数
//        long i = bis.skip(3);
//        System.out.println((char)bis.read());  //b
//
//        System.out.println(bis.available()); //18
//
//        byte[] bys1 = new byte[1024];
//        int n2 = bis.read(bys1);  // 一次读入一个字节数组   , 父类方法
//        System.out.println("读入的字节数："+ n2);  //18
//        //[99, 100, 101, 104, 101, 108, 108, 111, 13, 10, 98, 99, 100, 104, 101, 108, 13, 10, 0,
//        System.out.println("读入一个字节数组："+ Arrays.toString(bys1));
//
//        byte[] bys2 = new byte[1024];
//        int n3 = bis.read(bys2,0,3);  // 一次读入一个字节数组的一部分
//        System.out.println("读入的字节数："+ n3);
//        System.out.println("读入一个字节数组的一部分："+ Arrays.toString(bys2));

        // 3.循环读取

        // 读取数据
        // int by = 0;
        // while ((by = bis.read()) != -1) {
        // System.out.print((char) by);
        // }
        // System.out.println("---------");

        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = bis.read(bys)) != -1) {
            System.out.print(new String(bys, 0, len));
        }

        // 释放资源
        bis.close();
    }

}
