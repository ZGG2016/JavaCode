package javabase.list;

import java.util.Enumeration;
import java.util.Vector;
/*
 * ArrayList：遍历
 *      Enumeration
 *      elementAt()、size()
 * */
public class VectorDemo03 {
    public static void main(String[] args) {
        // 创建集合对象
        Vector<String> v = new Vector<String>();

        //public void addElement(E obj)
        // 将指定的组件添加到此向量的末尾，将其大小增加 1。如果向量的大小比容量大，则增大其容量。
        v.addElement("hello");
        v.addElement("world");
        v.addElement("java");
        v.addElement("java");

        //遍历

        //public Enumeration<E> elements()
        // 返回此向量的组件的枚举。返回的 Enumeration 对象将生成此向量中的所有项。
        // 生成的第一项为索引 0 处的项，然后是索引 1 处的项，依此类推。
        Enumeration<String> e = v.elements();
        while(e.hasMoreElements()){
            System.out.println(e.nextElement());

        }

        for (int x = 0; x < v.size(); x++) {
            String s = (String) v.elementAt(x);
            System.out.println(s);

        }
    }
}
