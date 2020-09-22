package jianzhioffer.part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class test1 {

    public String PrintMinNumber1(int[] numbers){

        StringBuilder s= new StringBuilder();
        ArrayList<Integer> list= new ArrayList<Integer>();
        int n=numbers.length;
        for(int i=0;i<n;i++){
            list.add(numbers[i]);

        }
        list.sort(new Comparator<Integer>() {

            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });

        for(int j:list){
            s.append(j);
        }
        return s.toString();
    }

    public String PrintMinNumber2(int [] numbers){
        if(numbers==null || numbers.length==0) return "";

        int n = numbers.length;
        String[] arr = new String[n];
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s1.compareTo(s2);
            }
        });

        for(int i=0;i<n;i++){
            sb.append(arr[i]);
        }
        return sb.toString();

    }
}
//����˼·��
//        �Ƚ���������ת����String���飬Ȼ��String������������ź�����ַ�������ƴ�ӳ������ؼ������ƶ��������
//        ����������£�
//        ��ab > ba �� a > b��
//        ��ab < ba �� a < b��
//        ��ab = ba �� a = b��
//        ����˵����
//        ���� "3" < "31"���� "331" > "313"������Ҫ������ƴ���������бȽ�