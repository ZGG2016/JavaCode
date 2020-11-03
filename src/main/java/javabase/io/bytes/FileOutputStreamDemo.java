package javabase.io.bytes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        // 1.构造方法
        /*
         * 创建字节输出流对象了做了几件事情：
         * A:调用系统功能去创建文件
         * B:创建fos对象
         * C:把fos对象指向这个文件
         */
//        FileOutputStream fos = new FileOutputStream(new File("fos.txt"));
//        FileOutputStream fos = new FileOutputStream(new File("fos.txt"),true);

//        FileOutputStream fos = new FileOutputStream("fos.txt");
//        FileOutputStream fos = new FileOutputStream("fos.txt",true);

        //2.成员方法

        //写一个字节
//        fos.write(97);
//        fos.write("\r\n".getBytes());  //数据的换行
//
//        byte[] bys={97,98,99,100,101};
//
//        //写一个字节数组
//        fos.write(bys);
//        fos.write(("hello").getBytes());
//        fos.write("\r\n".getBytes());
//
//        //写一个字节数组的一部分
//        fos.write(bys,1,3);
//        fos.write("hello".getBytes(),0,3);
//        fos.write("\r\n".getBytes());

        // 3.数据的换行、追加

        /*
         *  换行：
         * 		因为不同的系统针对不同的换行符号识别是不一样的?
         * 		      windows:\r\n 、 linux:\n  、  Mac:\r
         * 		而一些常见的个高级记事本，是可以识别任意换行符号的。
         * 追加：
         * 		利用带追加参数的构造方法
         *     【追加指的是，第二次执行程序产生的结果会在第一次执行程序产生结果的后面】
         */
//        for (int x = 0; x < 10; x++) {
//            fos.write(("hello" + x).getBytes());
//            fos.write("\r\n".getBytes());
//        }

        //关闭此文件输出流并释放与此流有关的所有系统资源。
//        fos.close();
        /*
         * 为什么一定要close()呢?
         * A:让流对象变成垃圾，这样就可以被垃圾回收器回收了
         * B:通知系统去释放跟该文件相关的资源
         */
        //java.io.IOException: Stream Closed
        //fos.write("java".getBytes());


        // 4.加入异常处理的字节输出流操作

        // 为了在finally里面能够看到该对象就必须定义到外面，为了访问不出问题，还必须给初始化值
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("fos.txt");
            fos.write("java".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 如果fos不是null，才需要close()
            if (fos != null) {
                // 为了保证close()一定会执行，就放到这里了
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
