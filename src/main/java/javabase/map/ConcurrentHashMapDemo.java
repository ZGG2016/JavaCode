package javabase.map;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args){
        ConcurrentHashMap<Integer,String> chm = new ConcurrentHashMap<>();

        for(int i=0;i<20;i++){
            chm.put(i,"hello"+i);
        }

        Set<Integer> ss = chm.keySet();
        for(Integer s:ss){
            System.out.println(s+":"+chm.get(s));
        }
    }
}
