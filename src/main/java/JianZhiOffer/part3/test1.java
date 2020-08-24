package JianZhiOffer.part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
//解题思路：
//        先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
//        排序规则如下：
//        若ab > ba 则 a > b，
//        若ab < ba 则 a < b，
//        若ab = ba 则 a = b；
//        解释说明：
//        比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较