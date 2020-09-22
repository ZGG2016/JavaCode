package javabase.collection;

import java.util.ArrayList;
import java.util.Collection;
/*
* Collection:测试不带All的方法
* */
public class CollectionDemo01 {
    public static void main(String[] args) {

        // 创建集合对象
        // Collection c = new Collection(); //错误，因为接口不能实例化
        Collection<String> c = new ArrayList<String>();

        // 1. boolean add(Object obj):添加一个元素

        // System.out.println("add:"+c.add("hello"));
        c.add("hello");
        c.add("world");
        c.add("java");

        // 2. void clear():移除所有元素

        // c.clear();

        // 3. boolean remove(Object o):移除一个元素

        // System.out.println("remove:" + c.remove("hello"));
        // System.out.println("remove:" + c.remove("javaee"));

        // 4. boolean contains(Object o)：判断集合中是否包含指定的元素

        // System.out.println("contains:"+c.contains("hello"));
        // System.out.println("contains:"+c.contains("android"));

        // 5. boolean isEmpty()：判断集合是否为空

        // System.out.println("isEmpty:"+c.isEmpty());

        //6. int size():元素的个数
        System.out.println("size:"+c.size());

        System.out.println("c:" + c);
    }
}
