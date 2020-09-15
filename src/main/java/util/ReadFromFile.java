package util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFromFile {
    public static void main(String[] args) throws IOException {

        //fisWriteData();
        bisWriteData();
    }

    //FileInputStream读取数据
    private static void fisWriteData() throws IOException {
        System.out.println("---------FileInputStream读取数据:一次读一个字节---------");
        FileInputStream fis1 = new FileInputStream("fos.txt");
        int b = 0;
        while ((b=fis1.read())!=-1){
            System.out.println((char)b);
        }
        fis1.close();

        System.out.println("---------FileInputStream读取数据:一次读一个字节数组---------");
        FileInputStream fis2 = new FileInputStream("fos.txt");
        byte[] bys = new byte[1024];
        int len = 0;
        while((len=fis2.read(bys))!=-1){
            System.out.println(new String(bys,0,len));
        }
        fis2.close();
    }

    private static void bisWriteData() throws IOException {

        System.out.println("---------BufferedInputStream读取数据:一次读一个字节---------");
        BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream("bos.txt"));
        int b = 0;
        while ((b=bis1.read())!=-1){
            System.out.println((char)b);
        }
        bis1.close();

        System.out.println("---------BufferedInputStream读取数据:一次读一个字节数组---------");
        BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream("bos.txt"));
        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = bis2.read(bys)) != -1) {
            System.out.print(new String(bys, 0, len));
        }
    }
}
