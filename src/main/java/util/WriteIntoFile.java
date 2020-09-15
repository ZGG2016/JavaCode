package util;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteIntoFile {
    public static void main(String[] args) throws IOException {

        //fosReadData();
        obsReadData();
    }

    //FileOutputStream写入数据
    private static void fosReadData() throws IOException {
        System.out.println("---------FileOutputStream写入数据---------");
        FileOutputStream fos = new FileOutputStream("fos.txt",true);
        for(int i=0;i<10;i++){
            fos.write(97);  //写一个字节
            fos.write("hello".getBytes(),0,3);  //写一个字节数组的一部分
            fos.write(("hello"+i).getBytes());  //写一个字节数组
            fos.write("\r\n".getBytes());

        }
        fos.close();
    }

    //BufferedOutputStream写入数据
    private static void obsReadData() throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("bos.txt"));

        for(int i=0;i<10;i++){
            bos.write(97);  //写一个字节
            bos.write(("hello"+i).getBytes(),0,3);  //写一个字节数组的一部分
            bos.write("\r\n".getBytes());

        }
        bos.close();
    }
}
