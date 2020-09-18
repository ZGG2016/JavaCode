package javabase.io.chars;

import java.io.*;
import java.util.Arrays;

public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {

        // 1.构造方法

//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("bw.txt")));

        BufferedReader br = new BufferedReader(new FileReader("bw.txt"));

        // 2.成员方法的基本使用
//        int ch = br.read();  // 一次读取一个字符
//        System.out.println("读的一个字符：" + ch);  //97
//        System.out.println("读的一个字符：" + (char)ch);  //a

        //跳过和丢弃此输入流中数据的 n 个字节
        //传入要跳过的字符数 ，返回实际跳过的字符数
//        long i = br.skip(1);
//        System.out.println((char)br.read());
//
//        char[] chs1 = new char[1024];
//        int n1 = br.read(chs1,0,3); //将字符读入字符数组中的一部分。
//        //3
//        System.out.println("读的字符数："+ n1);
//        System.out.println("读字符到字符数组的一部分："+ Arrays.toString(chs1)); //[a, b, c,  ,  ...]
//
//        String s = br.readLine();  //读取一个文本行
//        System.out.println("读的一个文本行："+ s); //aabcdebcd我爱林青霞林青霞z追加示例追加hello0

//        char[] chs2 = new char[1024];
//        int n2 = br.read(chs2); //将字符读入字符数组，父类方法
//        //3
//        System.out.println("读的字符数："+ n2);
//        System.out.println("读字符到字符数组："+ Arrays.toString(chs2));

        // 3.循环读取

        // 利用 一次读取一个字符
//        int nch1 = 0;
//        while ((nch1=br.read())!=-1){
//            System.out.println((char)nch1);
//        }

        // 利用 一次读取到一个字符数组
//        int nch2 = 0;
//        char[] chs = new char[1024];
//        while((nch2=br.read(chs))!=-1){
//            System.out.println(new String(chs, 0, nch2));
//        }

        //利用 一次读取一行
        String line = null;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }

    }
}
