package javabase.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/*
* Collection:遍历
* */
public class CollectionDemo04 {
    public static void main(String[] args) {
        // 创建集合对象
        Collection<Student> c = new ArrayList<Student>();

        // 创建学生对象
        Student s1 = new Student("林青霞", 27);
        Student s2 = new Student("风清扬", 30);
        Student s3 = new Student("令狐冲", 33);
        Student s4 = new Student("武鑫", 25);
        Student s5 = new Student("刘晓曲", 22);

        // 把学生添加到集合中
        c.add(s1);
        c.add(s2);
        c.add(s3);
        c.add(s4);
        c.add(s5);

        // 2.迭代器遍历
        Iterator it = c.iterator();
        while (it.hasNext()) {
            // System.out.println(it.next());
            Student s = (Student) it.next();
            System.out.println(s.getName() + "---" + s.getAge());
            //林青霞---27
            //风清扬---30
            //令狐冲---33
            //武鑫---25
            //刘晓曲---22
        }
        //从迭代器指向的 collection 中移除迭代器返回的最后一个元素（可选操作）。
        // 每次调用 next 只能调用一次此方法。
        it.remove();

        // 1.把集合转成数组
        Object[] objs = c.toArray();
        // 遍历数组
        for (int x = 0; x < objs.length; x++) {
            // System.out.println(objs[x]);

            Student s = (Student) objs[x];
            System.out.println(s.getName() + "---" + s.getAge());
            //林青霞---27
            //风清扬---30
            //令狐冲---33
            //武鑫---25
        }

        // for循环改写
        // for(Iterator it = c.iterator();it.hasNext();){
        // Student s = (Student) it.next();
        // System.out.println(s.getName() + "---" + s.getAge());
        // }
    }
}
