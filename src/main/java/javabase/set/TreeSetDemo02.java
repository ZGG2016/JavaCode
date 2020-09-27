package javabase.set;

import java.util.TreeSet;

/*
 * 自然顺序排序：存储自定义对象并遍历
 *
 * A:排序规则
 * 		自然排序，按照年龄从小到大排序；先年龄再姓名
 * B:元素唯一规则
 * 		成员变量值都相同即为同一个元素
 */
public class TreeSetDemo02 {
    public static void main(String[] args) {
        // 创建集合对象
        TreeSet<Student> ts = new TreeSet<Student>();

        // 创建元素
        Student s1 = new Student("linqingxia", 27);
        Student s2 = new Student("zhangguorong", 29);
        Student s3 = new Student("wanglihong", 23);
        Student s4 = new Student("linqingxia", 27);
        Student s5 = new Student("liushishi", 22);
        Student s6 = new Student("wuqilong", 40);
        Student s7 = new Student("fengqingy", 22);

        // 添加元素
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);
        ts.add(s7);

        // 遍历
        for (Student s : ts) {
            System.out.println(s.getName() + "---" + s.getAge());
        }
    }
}
