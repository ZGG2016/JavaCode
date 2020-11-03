package javabase.list;

import java.util.Vector;

/*
 * ArrayList：特有方法测试
 * */
public class VectorDemo02 {
    public static void main(String[] args) {
        // 创建集合对象
        Vector<String> v = new Vector<String>();

        //public void addElement(E obj)
        // 将指定的组件添加到此向量的末尾，将其大小增加 1。如果向量的大小比容量大，则增大其容量。
        v.addElement("hello");
        v.addElement("world");
        v.addElement("java");
        v.addElement("java");

        System.out.println(v);  //[hello, world, java, java]

        //public E elementAt(int index)返回指定索引处的组件。
        System.out.println("elementAt:" + v.elementAt(2));  //elementAt:java

        //public E firstElement()返回此向量的第一个组件（位于索引 0) 处的项）。
        System.out.println("firstElement:" + v.firstElement());  //firstElement:hello

        //public E lastElement()返回此向量的最后一个组件。索引 size() - 1 处。
        System.out.println("lastElement:" + v.lastElement());  //lastElement:java

        //public int indexOf(Object o,int index)
        // 返回此向量中第一次出现的指定元素的索引，从 index 处正向搜索，如果未找到该元素，则返回 -1。
        System.out.println("indexOf:" + v.indexOf("java",1));  //indexOf:2

        //public int lastIndexOf(Object o,int index)
        // 返回此向量中最后一次出现的指定元素的索引，从 index 处逆向搜索，如果未找到该元素，则返回 -1。
        System.out.println("lastIndexOf:" + v.lastIndexOf("world",2));  //lastIndexOf:1

        //public boolean removeElement(Object obj)从此向量中移除变量的第一个（索引最小的）匹配项。
        System.out.println("removeElement:"+v.removeElement("java")); //removeElement:true
        System.out.println("removeElement:"+v.removeElement("aaaa")); //removeElement:false
        System.out.println("after removeElement:"+v); //after removeElement:[hello, world, java]

        //public void removeElementAt(int index)删除指定索引处的组件。
        v.removeElementAt(0);
        System.out.println("after removeElementAt:"+v); //after removeElementAt:[world, java]

        //public void removeAllElements()从此向量中移除全部组件，并将其大小设置为零。
        v.removeAllElements();
        System.out.println("after removeAllElements:"+v); //after removeAllElements:[]

        //public void insertElementAt(E obj,int index)
        // 将指定对象作为此向量中的组件插入到指定的 index 处。
        v.insertElementAt("aaaa",0);
        v.insertElementAt("bbbb",1);
        v.insertElementAt("cccc",2);
        System.out.println("after insertElementAt:"+v); //after insertElementAt:[aaaa, bbbb, cccc]

        //public void setElementAt(E obj,int index)
        // 将此向量指定 index 处的组件设置为指定的对象。丢弃该位置以前的组件。
        v.setElementAt("dddd",2);
        System.out.println("setElementAt:"+v.elementAt(2)); //setElementAt:dddd

    }
}
