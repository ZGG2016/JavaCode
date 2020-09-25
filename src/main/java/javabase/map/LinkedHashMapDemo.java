package javabase.map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/*
* LinkedHashMap
* */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        // 1.构造方法
        //LinkedHashMap()构造一个带默认初始容量 (16) 和加载因子 (0.75) 的空插入顺序 LinkedHashMap 实例。
        LinkedHashMap<String, String> lhm1 = new LinkedHashMap<String, String>();

//LinkedHashMap(int initialCapacity)
//      构造一个带指定初始容量和默认加载因子 (0.75) 的空插入顺序 LinkedHashMap 实例。
// LinkedHashMap(int initialCapacity, float loadFactor)
//      构造一个带指定初始容量和加载因子的空插入顺序 LinkedHashMap 实例。
// LinkedHashMap(Map<? extends K,? extends V> m)
//      构造一个映射关系与指定映射相同的插入顺序 LinkedHashMap 实例。

        // LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)
        //      构造一个带指定初始容量、加载因子和排序模式的空 LinkedHashMap 实例。
        //      accessOrder - 排序模式 - 对于访问顺序，为 true；对于插入顺序，则为 false ???


        // 创建并添加元素
        lhm1.put("b", "hello");
        lhm1.put("a", "world");
        lhm1.put("d", "java");
        lhm1.put("c", "javaee");

        Set<String> set1 = lhm1.keySet();
        for(String s : set1){
            System.out.println(s+":"+lhm1.get(s));
        }
        System.out.println("-------------------------------------------");
        Set<Map.Entry<String, String>> mset = lhm1.entrySet();
        for(Map.Entry<String, String> s:mset){
            System.out.println(s.getKey()+":"+s.getValue());
        }
    }
}



