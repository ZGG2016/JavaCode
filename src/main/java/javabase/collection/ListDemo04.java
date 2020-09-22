package javabase.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/*
 * List：ListIterator迭代器方法测试
 * */
public class ListDemo04 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("java");

        /*
        * int nextIndex()
        *     返回对 next 的后续调用所返回元素的索引。（如果列表迭代器在列表的结尾，则返回列表的大小）。
         * */

        ListIterator lit = list.listIterator(); // 子类对象
        while (lit.hasNext()) {
            String s = (String) lit.next();
            System.out.println(s+":"+lit.nextIndex());
            //hello:1
            //world:2
            //java:3
        }

        System.out.println("-----------------");

//         System.out.println(lit.previous()+":"+lit.previousIndex()); // java:1
//         System.out.println(lit.previous()+":"+lit.previousIndex()); // world:0
//         System.out.println(lit.previous()+":"+lit.previousIndex()); // hello:-1
//        // NoSuchElementException
//        // System.out.println(lit.previous());

        /*
         * previousIndex():
         *     返回对 previous 的后续调用所返回元素的索引。（如果列表迭代器在列表的开始，则返回 -1）。
         * */
        while (lit.hasPrevious()) {
            String s = (String) lit.previous();
            System.out.println(s+":"+lit.previousIndex());
            //java:1
            //world:0
            //hello:-1
        }
        System.out.println("-----------------");

        /*
        * void set(E e)
        *      用指定元素替换 next 或 previous 返回的最后一个元素（可选操作）。
        * 只有在最后一次调用 next 或 previous 后既没有调用 ListIterator.remove
        * 也没有调用 ListIterator.add 时才可以进行该调用。
        * */
        lit.set("aaa");
        ListIterator lit3 = list.listIterator();
        while (lit3.hasNext()) {
            String s = (String) lit3.next();
            System.out.println(s+":"+lit3.nextIndex());
            //aaa:1
            //world:2
            //java:3
        }
        System.out.println("-----------------");

        /*
        * void remove()
        *     从列表中移除由 next 或 previous 返回的最后一个元素（可选操作）。
        * 对于每个 next 或 previous 调用，只能执行一次此调用。
        * 只有在最后一次调用 next 或 previous 之后，尚未调用 ListIterator.add 时才可以执行该调用。
         * */

        lit.remove();
        ListIterator lit2 = list.listIterator();
        while (lit2.hasNext()) {
            String s = (String) lit2.next();
            System.out.println(s+":"+lit2.nextIndex());
            //world:1
            //java:2
        }
        System.out.println("-----------------");

        /*
        * void add(E e)
        *    将指定的元素插入列表（可选操作）。
        * 该元素直接插入到 next 返回的下一个元素的前面（如果有），或者 previous 返回的下一个元素之后（如果有）
        * */
        lit.add("addobject");
        ListIterator lit4 = list.listIterator();
        while (lit4.hasNext()) {
            String s = (String) lit4.next();
            System.out.println(s+":"+lit4.nextIndex());
            //addobject:1
            //world:2
            //java:3
        }
    }
}
