package javabase.map;

import java.util.HashMap;
/*
* HashMap:构造方法
* */
public class HashMapDemo {
    public static void main(String[] args) {
        // 1.构造方法

        //构造一个具有默认初始容量 (16) 和默认加载因子 (0.75) 的空 HashMap。
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        //构造一个带指定初始容量和默认加载因子 (0.75) 的空 HashMap。
        HashMap<Integer, String> hm1 = new HashMap<Integer, String>(20);
        //构造一个带指定初始容量和加载因子的空 HashMap。
        HashMap<Integer, String> hm2 = new HashMap<Integer, String>(20, (float) 0.8);

        hm.put(27, "林青霞");
        hm.put(30, "风清扬");
        hm.put(28, "刘意");
        hm.put(29, "林青霞");


        //public HashMap(Map<? extends K,? extends V> m)
        // 构造一个映射关系与指定 Map 相同的新 HashMap。
        // 所创建的 HashMap 具有默认加载因子 (0.75) 和足以容纳指定 Map 中映射关系的初始容量。
        HashMap<Integer, String> hm3 = new HashMap<Integer, String>(hm);

        System.out.println(hm);
        System.out.println(hm3);
    }
}
