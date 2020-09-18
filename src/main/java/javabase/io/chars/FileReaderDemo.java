package javabase.io.chars;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
//        FileReader fr = new FileReader(new File("fw.txt"));
        FileReader fr = new FileReader("fw.txt");
        //只测试read

//        int nch1 = 0;
//        while ((nch1=fr.read())!=-1){
//            System.out.println((char)nch1);
//        }

        int nch2 = 0;
        char[] chs = new char[1024];
        while((nch2=fr.read(chs))!=-1){
            System.out.println(new String(chs, 0, nch2));
        }

        fr.close();
    }
}
