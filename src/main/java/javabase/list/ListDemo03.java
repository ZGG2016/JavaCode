package javabase.list;

import javabase.collection.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
* List：List特有遍历功能：
*      1.size()和get()方法结合使用
*      2.ListIterator迭代器
* */
public class ListDemo03 {
    public static void main(String[] args) {
        // 创建集合对象
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("java");

        //ListIterator迭代器
        ListIterator lit = list.listIterator();
        while (lit.hasNext()) {
            String s = (String) lit.next();
            System.out.println(s);
        }

        //size()和get()方法结合
        for (int x = 0; x < list.size(); x++) {
            String s = (String) list.get(x);
            System.out.println(s);
        }

//---------------------------------------------------------------------------

        //存储自定义对象并遍历
        // 创建集合对象
        List<Student> list2 = new ArrayList<Student>();
        Student s1 = new Student("林黛玉", 18);
        Student s2 = new Student("刘姥姥", 88);
        Student s3 = new Student("王熙凤", 38);
        list2.add(s1);
        list2.add(s2);
        list2.add(s3);

        // 迭代器遍历
        ListIterator lit2 = list2.listIterator();
        while (lit2.hasNext()) {
            Student s = (Student) lit2.next();
            System.out.println(s.getName() + "---" + s.getAge());
        }
        System.out.println("--------");

        // 普通for循环
        for (int x = 0; x < list2.size(); x++) {
            Student s = (Student) list2.get(x);
            System.out.println(s.getName() + "---" + s.getAge());
        }
    }
}
