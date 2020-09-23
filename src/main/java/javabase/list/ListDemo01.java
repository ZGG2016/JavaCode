package javabase.list;

import java.util.ArrayList;
import java.util.List;

/*
* List接口：测试特有成员方法
*        根据索引，增删改查
* */
public class ListDemo01 {
    public static void main(String[] args) {
        // 创建集合对象
        List<String> list = new ArrayList<String>();

        // 添加元素
        list.add("hello");
        list.add("world");
        list.add("java");

        /*
        * 1. void add(int index,Object element):在指定位置添加元素
        * */
         list.add(1, "android");//没有问题
         //IndexOutOfBoundsException
//         list.add(11, "javaee");//有问题
         list.add(3, "javaee"); //没有问题
//         list.add(4, "javaee"); //有问题

        /*
        * 2. Object get(int index):获取指定位置的元素
        *
        * */
         System.out.println("get:" + list.get(1));
         //IndexOutOfBoundsException
//         System.out.println("get:" + list.get(11));

        /*
        * 3. Object remove(int index)：
        *     根据索引删除元素,返回被删除的元素
        * */
         System.out.println("remove:" + list.remove(1));
         //IndexOutOfBoundsException
         //System.out.println("remove:" + list.remove(11));

        /*
        * 4. Object set(int index,Object element):
        *     根据索引修改元素，返回被修饰的元素
        * */
        System.out.println("set:" + list.set(1, "javaee"));

        /*
        * 5.int indexOf(Object o)
        *     返回此列表中第一次出现的指定元素的索引；如果此列表不包含该元素，则返回 -1。
        * */
        System.out.println("set:" + list.indexOf("test"));  //-1
        System.out.println("set:" + list.indexOf("hello")); //0

        /*
        * 6. int lastIndexOf(Object o)
        *  返回此列表中最后出现的指定元素的索引；如果列表不包含此元素，则返回 -1。
        * */
        System.out.println("set:" + list.lastIndexOf("hello")); //0

        // 创建集合对象
        List<String> list2 = new ArrayList<String>();

        // 添加元素
        list2.add("aaaa");
        list2.add("bbbb");
        list2.add("cccc");

        /*
        * 1.boolean addAll(int index,Collection<? extends E> c)
        *   将指定 collection 中的所有元素都插入到列表中的指定位置（可选操作）。
        *   将当前处于该位置的元素（如果有的话）和所有后续元素向右移动（增加其索引）。
        *   新元素将按照它们通过指定 collection 的迭代器所返回的顺序出现在此列表中。
        * */
        list.addAll(1,list2); //list:[hello, aaaa, bbbb, cccc, world, java]

        System.out.println("list:" + list);
    }
}
