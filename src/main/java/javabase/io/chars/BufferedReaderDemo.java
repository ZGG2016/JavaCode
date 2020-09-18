package javabase.io.chars;

import java.io.*;
import java.util.Arrays;

public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {

        // 1.���췽��

//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("bw.txt")));

        BufferedReader br = new BufferedReader(new FileReader("bw.txt"));

        // 2.��Ա�����Ļ���ʹ��
//        int ch = br.read();  // һ�ζ�ȡһ���ַ�
//        System.out.println("����һ���ַ���" + ch);  //97
//        System.out.println("����һ���ַ���" + (char)ch);  //a

        //�����Ͷ����������������ݵ� n ���ֽ�
        //����Ҫ�������ַ��� ������ʵ���������ַ���
//        long i = br.skip(1);
//        System.out.println((char)br.read());
//
//        char[] chs1 = new char[1024];
//        int n1 = br.read(chs1,0,3); //���ַ������ַ������е�һ���֡�
//        //3
//        System.out.println("�����ַ�����"+ n1);
//        System.out.println("���ַ����ַ������һ���֣�"+ Arrays.toString(chs1)); //[a, b, c,  ,  ...]
//
//        String s = br.readLine();  //��ȡһ���ı���
//        System.out.println("����һ���ı��У�"+ s); //aabcdebcd�Ұ�����ϼ����ϼz׷��ʾ��׷��hello0

//        char[] chs2 = new char[1024];
//        int n2 = br.read(chs2); //���ַ������ַ����飬���෽��
//        //3
//        System.out.println("�����ַ�����"+ n2);
//        System.out.println("���ַ����ַ����飺"+ Arrays.toString(chs2));

        // 3.ѭ����ȡ

        // ���� һ�ζ�ȡһ���ַ�
//        int nch1 = 0;
//        while ((nch1=br.read())!=-1){
//            System.out.println((char)nch1);
//        }

        // ���� һ�ζ�ȡ��һ���ַ�����
//        int nch2 = 0;
//        char[] chs = new char[1024];
//        while((nch2=br.read(chs))!=-1){
//            System.out.println(new String(chs, 0, nch2));
//        }

        //���� һ�ζ�ȡһ��
        String line = null;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }

    }
}
