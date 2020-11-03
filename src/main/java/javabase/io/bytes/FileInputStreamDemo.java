package javabase.io.bytes;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {

        // 1.构造方法

//        FileInputStream fis = new FileInputStream(new File("fos.txt"));
        FileInputStream fis = new FileInputStream("fos.txt");

        // 2.成员方法的基本使用

        //返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取（或跳过）的估计剩余字节数。
//        System.out.println(fis.available()); //103
//
//        int n1 = fis.read();  // 一次读取一个字节
//        System.out.println("读的字节："+n1);
//        System.out.println("读的字节为："+(char)n1);
//
//        //跳过和丢弃此输入流中数据的 n 个字节
//        //传入要跳过的字符数 ，返回实际跳过的字符数
//        long i = fis.skip(3);
//        System.out.println((char)fis.read());  //b
//
//        System.out.println(fis.available()); //98
//
//        byte[] bys1 = new byte[1024];
//        int n2 = fis.read(bys1);  // 一次读入一个字节数组 , 父类方法
//        System.out.println("读入的字节数："+ n2);
//        System.out.println("读入一个字节数组："+ Arrays.toString(bys1));
//
//        byte[] bys2 = new byte[1024];
//        int n3 = fis.read(bys2,0,3);  // 一次读入一个字节数组的一部分
//        System.out.println("读入的字节数："+ n3);
//        System.out.println("读入一个字节数组的一部分："+ Arrays.toString(bys2));

        //3.循环读取

        int by = 0;
        while ((by = fis.read()) != -1) {
            System.out.print((char) by);
        }

        // 数组的长度一般是1024或者1024的整数倍
        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = fis.read(bys)) != -1) {   // 一次读取1024个字节
            System.out.print(new String(bys, 0, len));
        }

        fis.close();
    }
}
