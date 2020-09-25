package javabase.map;

import java.util.*;

/*
 * TreeMap:遍历
 * */
public class TreeMapDemo03 {
    public static void main(String[] args) {
        TreeMap<String, String> tm = new TreeMap<String, String>();
        tm.put("hello", "你好");
        tm.put("world", "世界");
        tm.put("java", "爪哇");
        tm.put("javaee", "爪哇EE");

        // 1.正序
        Set<String> set = tm.keySet();
        for (String key : set) {
            String value = tm.get(key);
            System.out.println(key + "---" + value);
        }
        System.out.println("---------------------------");

        //2.正序
        Set<Map.Entry<String, String>> mes = tm.entrySet();
        for(Map.Entry<String, String> me:mes){
            System.out.println(me.getKey()+":"+me.getValue());
        }
        System.out.println("---------------------------");

        //3.逆序
        NavigableSet<String> nbs = tm.descendingKeySet();
        for(String nb:nbs){
            System.out.println(nb+":"+tm.get(nb));
        }

        System.out.println("---------------------------");

        //4.逆序
        NavigableMap<String, String> nm = tm.descendingMap();
        Set<String> ss = nm.keySet();
        for(String s:ss){
            System.out.println(s+":"+tm.get(s));
        }
    }
}
