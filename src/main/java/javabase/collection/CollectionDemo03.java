package javabase.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
* Collection:集合遍历
* */
public class CollectionDemo03 {
    public static void main(String[] args) {
        // 创建集合对象
        Collection<String> c = new ArrayList<String>();

        // 添加元素
        c.add("hello"); // Object obj = "hello"; 向上转型
        c.add("world");
        c.add("java");

        /*
        * 1. 转成数组遍历
        *     Object[] toArray():把集合转成数组，可以实现集合的遍历
        *     <T> T[] toArray(T[] a) 返回数组的运行时类型与指定数组的运行时类型相同。
        * */

        Object[] objs = c.toArray();
        for (int x = 0; x < objs.length; x++) {
            // System.out.println(objs[x]);
            // 我知道元素是字符串，我在获取到元素的的同时，还想知道元素的长度。
            // System.out.println(objs[x] + "---" + objs[x].length());
            // 上面的实现不了，原因是Object中没有length()方法
            // 我们要想使用字符串的方法，就必须把元素还原成字符串
            // 向下转型
            String s = (String) objs[x];
            System.out.println(s + "---" + s.length());
        }
//        String[] ss = c.toArray(new String[0]);
//        for(int i=0;i<ss.length;i++){
//            String s = ss[i];
//            System.out.println(s);
//        }

        /*
         * 2.迭代器遍历:
         * Iterator iterator():迭代器，集合的专用遍历方式
   		 *      Object next():获取元素,并移动到下一个位置。
   		 *	         NoSuchElementException：没有这样的元素，因为你已经找到最后了。
         *      boolean hasNext():如果仍有元素可以迭代，则返回 true。
         */

        Iterator it = c.iterator(); // 实际返回的肯定是子类对象，这里是多态
        while(it.hasNext()){
            String s = (String)it.next();
            System.out.println(s + "---" + s.length());
        }
    }
}
