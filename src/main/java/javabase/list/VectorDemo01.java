package javabase.list;

import java.util.Vector;
/*
* Vector：构造方法
* */
public class VectorDemo01 {
    public static void main(String[] args) {
        // 1.构造方法

        //构造一个空向量，使其内部数据数组的大小为 10，其标准容量增量为零。
        Vector<String> v1 = new Vector<String>();
        //使用指定的初始容量和等于零的容量增量构造一个空向量。
        Vector<String> v2 = new Vector<String>(20);
        //使用指定的初始容量和容量增量构造一个空的向量。
        Vector<String> v3 = new Vector<String>(20,10);

        //public Vector(Collection<? extends E> c)
        // 构造一个包含指定 collection 中的元素的向量，这些元素按其 collection 的迭代器返回元素的顺序排列。

        //public int capacity() 返回此向量的当前容量。
        System.out.println(v1.capacity()+":"+v2.capacity()+":"+v3.capacity());  //10:20:20
        //public int size()返回此向量中的组件数。
        System.out.println(v1.size()+":"+v2.size()+":"+v3.size());  //0:0:0

        for(int i=0;i<30;i++){
            v1.addElement("hello"+i);
            v2.addElement("hello"+i);
            v3.addElement("hello"+i);
        }

        System.out.println(v1.capacity()+":"+v2.capacity()+":"+v3.capacity()); //40:40:30
        System.out.println(v1.size()+":"+v2.size()+":"+v3.size());  //30:30:30

    }
}
