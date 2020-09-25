package javabase.map;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
/*
* Hashtable：方法及遍历
* */
public class HashTableDemo {
    public static void main(String[] args){
        Hashtable<String, Integer> num = new Hashtable<String, Integer>();
        num.put("one", 1);
        num.put("two", 2);
        num.put("three", 3);

        //public Enumeration<V> elements()返回此哈希表中的值的枚举。
        Enumeration<Integer> val = num.elements();
        while(val.hasMoreElements()){
            System.out.println(val.nextElement());
            //2
            //1
            //3
        }
        System.out.println("------------------------------");

        //public Enumeration<K> keys()返回此哈希表中的键的枚举。
        Enumeration<String> k = num.keys();
        while(k.hasMoreElements()){
            System.out.println(k.nextElement());
            //two
            //one
            //three
        }
        System.out.println("------------------------------");

        //public String toString()返回此 Hashtable 对象的字符串表示形式，
        // 其形式为 ASCII 字符 ", " （逗号加空格）分隔开的、括在括号中的一组条目。
        // 每个条目都按以下方式呈现：键，一个等号 = 和相关元素，其中 toString 方法用于将键和元素转换为字符串。
        System.out.println(num.toString());//{two=2, one=1, three=3}
        System.out.println("------------------------------");


        Set<String> ss = num.keySet();
        for(String s : ss){
            System.out.println(s+":"+num.get(s));
        }
        //two:2
        //one:1
        //three:3
        System.out.println("------------------------------");

        Set<Map.Entry<String, Integer>> sse = num.entrySet();
        for(Map.Entry<String, Integer> se:sse){
            System.out.println(se.getKey()+":"+se.getValue());
        }
    }
}
