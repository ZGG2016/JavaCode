package javabase.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/*
 * Collection
 * 		|--List
 * 			有序(存储顺序和取出顺序一致),可重复
 * 		|--Set
 * 			无序(存储顺序和取出顺序不一致),唯一
 *
 * HashSet：它不保证 set 的迭代顺序；特别是它不保证该顺序恒久不变。
 * 注意：虽然Set集合的元素无序，但是，作为集合来说，它肯定有它自己的存储顺序，
 * 而你的顺序恰好和它的存储顺序一致，这代表不了有序，你可以多存储一些数据，就能看到效果。
 */
public class SetDemo {
    public static void main(String[] args) {
        // 创建集合对象
        Set<String> set = new HashSet<String>();

        // boolean add(E e)如果 set 中尚未存在指定的元素，则添加此元素（可选操作）。
        //如果 set 尚未包含指定的元素，则返回 true
        //如果此 set 已经包含该元素，则该调用不改变此 set 并返回 false。
        set.add("hello");
        set.add("java");
        set.add("world");
        System.out.println("add:"+set.add("python")); //add:true
        System.out.println("add:"+set.add("java")); //add:false

        //boolean remove(Object o)如果 set 中存在指定的元素，则将其移除（可选操作）。
        //如果此 set 包含指定的对象，则返回 true
        System.out.println("remove:"+set.remove("python")); //remove:true

        //boolean contains(Object o)如果 set 包含指定的元素，则返回 true。
        System.out.println("contains:"+set.contains("hello"));  //contains:true
        System.out.println("contains:"+set.contains("aaaaa"));  //contains:false

        //int size()返回 set 中的元素数（其容量）。
        System.out.println("size:"+set.size());  //size:3

        //boolean isEmpty()如果 set 不包含元素，则返回 true。
        System.out.println("isEmpty:"+set.isEmpty());  //isEmpty:false

        ArrayList<String> al = new ArrayList<String>();
        al.add("hello");
        al.add("world");
        al.add("scala");

        //boolean containsAll(Collection<?> c)
        // 如果此 set 包含指定 collection 的所有元素，则返回 true。
        System.out.println("containsAll:"+set.containsAll(al)); //containsAll:false

        //boolean addAll(Collection<? extends E> c)  并集
        // 如果 set 中没有指定 collection 中的所有元素，则将其添加到此 set 中（可选操作）。
//        System.out.println("addAll:"+set.addAll(al)); //addAll:true
//        System.out.println("addAll:"+set); //addAll:[java, world, scala, hello]

        //boolean retainAll(Collection<?> c)  交集
        // 仅保留 set 中那些包含在指定 collection 中的元素（可选操作）。
//        System.out.println("retainAll:"+set.retainAll(al)); //retainAll:true
//        System.out.println("retainAll:"+set); //retainAll:[world, hello]

        //boolean removeAll(Collection<?> c)  不对称差集
        // 移除 set 中那些包含在指定 collection 中的元素（可选操作）。
//        System.out.println("removeAll:"+set.removeAll(al)); //removeAll:true
//        System.out.println("removeAll:"+set); //removeAll:[java]

//-------------------------------------------------------------------------------------------
        //遍历

        // 1.增强for
        for (String s : set) {
            System.out.println(s);
            //java
            //world
            //hello
        }
        System.out.println("-----------------------");

        // 2.迭代器
        Iterator<String> its = set.iterator();
        while(its.hasNext()){
            System.out.println(its.next());
        }
        System.out.println("-----------------------");

        //3.转数组
        String[] ss = set.toArray(new String[0]);
        for(String s:ss){
            System.out.println(s);
        }
        System.out.println("-----------------------");

    }
}
