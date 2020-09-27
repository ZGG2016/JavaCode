package javabase.set;

import java.util.Comparator;
import java.util.TreeSet;

/*
* 比较器排序
* */
public class TreeSetDemo03 {
    public static void main(String[] args) {
        // 创建集合对象
        // public TreeSet(Comparator comparator) //比较器排序（方法1）
        // TreeSet<Teacher> ts = new TreeSet<Teacher>(new MyComparator());

        // 如果一个方法的参数是接口，那么真正要的是接口的实现类的对象
        // 而匿名内部类就可以实现这个东西（方法2）
        TreeSet<Teacher> ts = new TreeSet<Teacher>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher s1, Teacher s2) {
                // 姓名长度
                int num = s1.getName().length() - s2.getName().length();
                // 姓名内容
                int num2 = num == 0 ? s1.getName().compareTo(s2.getName())
                        : num;
                // 年龄
                int num3 = num2 == 0 ? s1.getAge() - s2.getAge() : num2;
                return num3;
            }
        });

        // 创建元素
        Teacher s1 = new Teacher("linqingxia", 27);
        Teacher s2 = new Teacher("zhangguorong", 29);
        Teacher s3 = new Teacher("wanglihong", 23);
        Teacher s4 = new Teacher("linqingxia", 27);
        Teacher s5 = new Teacher("liushishi", 22);
        Teacher s6 = new Teacher("wuqilong", 40);
        Teacher s7 = new Teacher("fengqingy", 22);
        Teacher s8 = new Teacher("linqingxia", 29);

        // 添加元素
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);
        ts.add(s7);
        ts.add(s8);

        // 遍历
        for (Teacher s : ts) {
            System.out.println(s.getName() + "---" + s.getAge());
        }
    }
}
