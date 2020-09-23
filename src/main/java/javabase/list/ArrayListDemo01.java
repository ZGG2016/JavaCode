package javabase.list;

import java.util.ArrayList;
/*
* ArrayList：构造方法测试
* */
public class ArrayListDemo01 {
    public static void main(String[] args) {
        // 1.构造方法

        ArrayList<String> al = new ArrayList<String>();  //默认容量是10
//        ArrayList<String> al2 = new ArrayList<String>(100);  //指定容量是100

        al.add("hello");
        al.add("world");
        al.add("java");
        System.out.println(al); //[hello, world, java]

        System.out.println("--------------------------");

        //构造一个包含指定 collection 的元素的列表，这些元素是按照该 collection 的迭代器返回它们的顺序排列的。
        ArrayList<String> al3 = new ArrayList<String>(al);
        System.out.println(al3);  //[hello, world, java]

    }
}
