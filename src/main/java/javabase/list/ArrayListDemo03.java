package javabase.list;

import javabase.collection.Student;

import java.util.ArrayList;
import java.util.Iterator;

/*
* ArrayList：遍历
*    1.迭代器 （ListIterator、Iterator）
*    2.get()、size()
* */
public class ArrayListDemo03 {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("hello");
        al.add("world");
        al.add("java");

        // 1.迭代器
        Iterator<String> it = al.iterator();
        while (it.hasNext()) {
            String s = (String) it.next();
            System.out.println(s);
        }

        System.out.println("-----------");

        // 2.get()、size()
        for (int x = 0; x < al.size(); x++) {
            String s = (String) al.get(x);
            System.out.println(s);
        }
//------------------------------------------------------------------------
        //存储自定义对象并遍历
        ArrayList<Student> al2 = new ArrayList<Student>();

        // 创建学生对象
        Student s1 = new Student("武松", 30);
        Student s2 = new Student("鲁智深", 40);
        Student s3 = new Student("林冲", 36);
        Student s4 = new Student("杨志", 38);

        // 添加元素
        al2.add(s1);
        al2.add(s2);
        al2.add(s3);
        al2.add(s4);

        // 1.迭代器
        Iterator<Student> it2 = al2.iterator();
        while (it2.hasNext()) {
            Student s = (Student) it2.next();
            System.out.println(s.getName() + "---" + s.getAge());
        }

        System.out.println("----------------");
        // 2.get()、size()
        for (int x = 0; x < al2.size(); x++) {
            // ClassCastException 注意，千万要搞清楚类型
            // String s = (String) array.get(x);
            // System.out.println(s);

            Student s = (Student) al2.get(x);
            System.out.println(s.getName() + "---" + s.getAge());
        }
    }
}
