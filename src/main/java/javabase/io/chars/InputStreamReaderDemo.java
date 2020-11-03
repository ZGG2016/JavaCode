package javabase.io.chars;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException {
        // 1.构造方法

        // InputStreamReader isr = new InputStreamReader(new FileInputStream(
        // "osw.txt"));
         InputStreamReader isr = new InputStreamReader(new FileInputStream(
                 "osw.txt"), "GBK");

         // 2.成员方法的基本使用

//        int ch = isr.read(); // 一次读取一个字符
//        //a
//        System.out.println("读单个字符："+(char) ch);
//        System.out.println(ch);  //97
//
//        char[] chs1 = new char[1024];
//        int n1 = isr.read(chs1,0,3); //将字符读入字符数组中的一部分。
//        //3
//        System.out.println("读的字符数："+ n1);
//        //[a, b, c,  ,  , ...]
//        System.out.println("读字符到字符数组的一部分："+ Arrays.toString(chs1));
//
//        char[] chs2 = new char[1024];
//        int n2 = isr.read(chs2);  //将字符读入字符数组   ，  父类方法
//        //20
//        System.out.println("读的字符数："+ n2);
//        //接着上个读取：[d, e, b, c, d, 我, 爱, 林, 青, 霞, 林, 青, 霞, z, 追, 加, 示, 例, 追, 加,  ...]
//        System.out.println("读字符到字符数组："+ Arrays.toString(chs2));
//
//        //判断此流是否支持 mark() 操作。默认实现始终返回 false。子类应重写此方法。
//        System.out.println(isr.markSupported());  //false

        // 3.循环读取
        // 利用 一次读取一个字符
//        int nch1 = 0;
//        while((nch1=isr.read())!=-1){
//            System.out.println((char)nch1);
//        }

        // 利用 一次读取到一个字符数组
        int nch2 = 0;
        char[] chs3 = new char[1024];
        while((nch2=isr.read(chs3))!=-1){
            System.out.println(new String(chs3, 0, nch2));
        }

        //判断此流是否已经准备好用于读取。如果其输入缓冲区不为空，或者可从底层字节流读取字节，
        // 则 InputStreamReader 已做好被读取准备。
//        System.out.println(isr.ready()); //false

        isr.close();
    }
}
