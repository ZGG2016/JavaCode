package javabase.io.chars;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberReaderDemo {
    public static void main(String[] args) throws IOException {
        LineNumberReader lnr = new LineNumberReader(new FileReader("bos.txt"));
        // 其父是BufferReader，所有可以使用其父的所有方法
        //这里只测试readLine()

        String line = null;
        while((line=lnr.readLine())!=null){
            int n = lnr.getLineNumber();
            if(n==10){
                lnr.setLineNumber(11);
            }
            System.out.println("这是第 "+lnr.getLineNumber()+" 行的数据：");
            System.out.println(line);
            //这是第 8 行的数据：
            //ahel
            //这是第 9 行的数据：
            //ahel
            //这是第 11 行的数据：
            //ahel
        }
    }
}
