package javabase.set;

import java.util.Iterator;
import java.util.LinkedHashSet;
/*
* 元素有序唯一:
	由链表保证元素有序。(存储和取出是一致)
	由哈希表保证元素唯一
* */
public class LinkedHashSetDemo {
    public static void main(String[] args) {
        // 创建集合对象
        LinkedHashSet<String> hs = new LinkedHashSet<String>();

        // 创建并添加元素
        hs.add("hello");
        hs.add("world");
        hs.add("java");

        // 1.遍历
        for (String s : hs) {
            System.out.println(s);
        }
        //hello
        //world
        //java
        System.out.println("-----------------------");

        // 2.迭代器
        Iterator<String> its = hs.iterator();
        while(its.hasNext()){
            System.out.println(its.next());
        }
        System.out.println("-----------------------");

        //3.转数组
        String[] ss = hs.toArray(new String[0]);
        for(String s:ss){
            System.out.println(s);
        }
    }
}
