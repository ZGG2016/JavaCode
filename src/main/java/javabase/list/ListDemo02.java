package javabase.list;

import javabase.collection.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
* List:collection的遍历方式
* */
public class ListDemo02 {
    public static void main(String[] args) {
        // 创建集合对象
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("java");

        // 遍历集合
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String s = (String) it.next();
            System.out.println(s);
        }

        //转数组
        String[] ss = list.toArray(new String[0]);
        for(int i=0;i<ss.length;i++){
            String s = ss[i];
            System.out.println(s);
        }

//---------------------------------------------------------------------------------------

        //存储自定义对象并遍历
        List<javabase.collection.Student> list2 = new ArrayList<javabase.collection.Student>();

        // 创建学生对象
        javabase.collection.Student s1 = new javabase.collection.Student("白骨精", 30);
        javabase.collection.Student s2 = new javabase.collection.Student("蜘蛛精", 40);
        javabase.collection.Student s3 = new javabase.collection.Student("观音姐姐", 22);

        // 把学生对象添加到集合对象中
        list2.add(s1);
        list2.add(s2);
        list2.add(s3);

        // 遍历
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            javabase.collection.Student s = (Student) it2.next();
            System.out.println(s.getName() + "---" + s.getAge());
        }
    }
}
