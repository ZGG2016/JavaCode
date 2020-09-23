package javabase.list;

import java.lang.reflect.Field;
import java.util.ArrayList;
/*
* ArrayList：特有方法测试
* */
public class ArrayListDemo02 {
    public static void main(String[] args) throws Exception {
//        calTime1();
//        calTime2();

//        testClone();
//        testIndexOf();
        testtrimToSize();
    }

    /*
     * public void ensureCapacity(int minCapacity)
     *    在添加大量元素前，应用程序可以使用 ensureCapacity 操作来增加 ArrayList 实例的容量。
     *     这可以减少递增式再分配的数量。
     * */
    private static void calTime1(){
        ArrayList<String> al = new ArrayList<String>();  //默认容量是10
        long startTime = System.currentTimeMillis();
        for(int i=0;i<20000;i++){
            al.add("hello"+i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime); //14
    }

    private static void calTime2(){
        ArrayList<String> al = new ArrayList<String>();
        al.ensureCapacity(20000);
        long startTime = System.currentTimeMillis();
        for(int i=0;i<20000;i++){
            al.add("hello"+i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime); //6
    }

    //public Object clone()  返回此 ArrayList 实例的浅表副本。（不复制这些元素本身。）
    private static void testClone(){
        ArrayList<String> al = new ArrayList<String>();
        al.add("hello");
        al.add("world");
        al.add("java");
        System.out.println(al); //[hello, world, java]
        ArrayList<String> alc = (ArrayList<String>) al.clone();
        alc.add("aaa");
        System.out.println(alc);  //[hello, world, java, aaa]
        System.out.println(al);  //[hello, world, java]

    }

    /*
    * public int indexOf(Object o)
    *    返回此列表中首次出现的指定元素的索引，或如果此列表不包含元素，则返回 -1。
    *   更确切地讲，返回满足 (o==null ? get(i)==null : o.equals(get(i))) 的最低索引 i，如果不存在此类索引，则返回 -1。
     *
    * public int lastIndexOf(Object o)
    *   返回此列表中最后一次出现的指定元素的索引，或如果此列表不包含索引，则返回 -1。
    *   更确切地讲，返回满足 (o==null ? get(i)==null : o.equals(get(i))) 的最高索引 i，如果不存在此类索引，则返回 -1。
     * */
    private static void testIndexOf(){
        ArrayList<String> al = new ArrayList<String>();
        al.add("hello");
        al.add("world");
        al.add("java");
        al.add("hello");
        System.out.println(al); //[hello, world, java, hello]
        int i = al.indexOf("hello");
        int j = al.lastIndexOf("hello");
        int k = al.indexOf("aaa");
        System.out.println(i+":"+j+":"+k); //0:3:-1

    }

    //public void trimToSize()
    // 将此 ArrayList 实例的容量调整为列表的当前大小。应用程序可以使用此操作来最小化 ArrayList 实例的存储量。
    private static void testtrimToSize() throws Exception {
        ArrayList<String> al = new ArrayList<String>();
        al.add("hello");
        al.add("world");
        al.add("java");
        al.add("hello");
        System.out.println(getCapacity(al)); //10  默认
        al.trimToSize();
        System.out.println(getCapacity(al)); //4

    }
    private static int getCapacity(ArrayList<?> l) throws Exception {
        Field dataField = ArrayList.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        return ((Object[]) dataField.get(l)).length;
    }
}
