package javabase.map;

import java.util.*;
/*
* TreeMap:成员方法
* */
public class TreeMapDemo02 {
    public static void main(String[] args) {
        // 2.成员方法。具体描述见api
        TreeMap<Integer, String> tm1 = new TreeMap<Integer, String>();
        TreeMap<String, String> tm2 = new TreeMap<String, String>(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.length()-o2.length();
                    }
                }
        );
        for(int i=0;i<10;i++){
            tm1.put(i,"hello"+i);
        }

        //逆序输出
        /*
         * public NavigableSet<K> descendingKeySet()
         *       返回此映射中所包含键的逆序 NavigableSet 视图
         *
         * public NavigableMap<K,V> descendingMap()
         *       返回此映射中所包含映射关系的逆序视图。
         * */
        NavigableSet<Integer> nbs = tm1.descendingKeySet();
        System.out.println("descendingKeySet:");
        for(Integer nb:nbs){
            System.out.println(nb+":"+tm1.get(nb));
            //9:hello9
            //8:hello8
            //7:hello7
            //...
        }

        System.out.println("---------------------------");

        NavigableMap<Integer, String>  nm = tm1.descendingMap();
        Set<Integer> ss = nm.keySet();
        System.out.println("descendingMap:");
        for(Integer s:ss){
            System.out.println(s+":"+tm1.get(s));
        }
        System.out.println("---------------------------");

        //获取元素1
        /*
        * public Map.Entry<K,V> ceilingEntry(K key)
        *       返回：最小键大于等于 key 的条目；如果不存在这样的键，则返回 null
        * public K ceilingKey(K key)
        *       返回大于等于给定键的最小键；如果不存在这样的键，则返回 null。
        * public Map.Entry<K,V> higherEntry(K key)
        *       返回：最小键大于 key 的条目；如果不存在这样的键，则返回 null
        * public K higherKey(K key)
        *       返回严格大于给定键的最小键；如果不存在这样的键，则返回 null。
        * */
        Map.Entry<Integer, String> ce = tm1.ceilingEntry(5);
        System.out.println("ceilingEntry:"+ce); //5=hello5

        Integer ck = tm1.ceilingKey(5);
        System.out.println("ceilingKey:"+ck); //5

        Map.Entry<Integer, String> he = tm1.higherEntry(5);
        System.out.println("higherEntry:"+he); //6=hello6

        Integer hk = tm1.higherKey(5);
        System.out.println("higherKey:"+hk); //6

        //获取元素2
        /*
        * public Map.Entry<K,V> firstEntry()
        *       返回一个与此映射中的最小键关联的键-值映射关系；如果映射为空，则返回 null
        * public Map.Entry<K,V> floorEntry(K key)
        *       返回一个键-值映射关系，它与小于等于给定键的最大键关联；如果不存在这样的键，则返回 null。
        * public K floorKey(K key)从接口 NavigableMap 复制的描述
        *       返回小于等于给定键的最大键；如果不存在这样的键，则返回 null。
        * public Map.Entry<K,V> higherEntry(K key)
        * public K higherKey(K key)
        * public K firstKey()
        * public Map.Entry<K,V> lastEntry()
        * public K lastKey()
        * */
        Map.Entry<Integer, String> fme = tm1.firstEntry();
        System.out.println("firstEntry:"+fme);  //0=hello0
        System.out.println("firstKey:"+tm1.firstKey()); //0
        System.out.println("lastEntry:"+tm1.lastEntry()); //9=hello9
        System.out.println("lastKey:"+tm1.lastKey()); //9
//        System.out.println("lastKey:"+tm2.lastKey());//java.util.NoSuchElementException

        System.out.println("---------------------------");

        //移除元素
        /*
        * public Map.Entry<K,V> pollFirstEntry()
        *       移除并返回与此映射中的最小键关联的键-值映射关系；如果映射为空，则返回 null。
        * public Map.Entry<K,V> pollLastEntry()
        *       移除并返回与此映射中的最大键关联的键-值映射关系；如果映射为空，则返回 null。
        * public V remove(Object key)
        *        如果此 TreeMap 中存在该键的映射关系，则将其删除。
         * */

        Map.Entry<Integer, String> pme1 = tm1.pollFirstEntry();
        System.out.println("pollLastEntry:"+pme1); //pollLastEntry:0=hello0
//pollFirstEntry:{1=hello1, 2=hello2, 3=hello3, 4=hello4, 5=hello5, 6=hello6, 7=hello7, 8=hello8, 9=hello9}
        System.out.println("pollFirstEntry:"+tm1);

        Map.Entry<Integer, String> pme2 = tm1.pollLastEntry();
        System.out.println("pollLastEntry:"+pme2); //pollLastEntry:9=hello9
        //pollLastEntry:{1=hello1, 2=hello2, 3=hello3, 4=hello4, 5=hello5, 6=hello6, 7=hello7, 8=hello8}
        System.out.println("pollLastEntry:"+tm1);

        String rmp = tm1.remove(0);
        System.out.println("remove:"+rmp);
        System.out.println("---------------------------");

        //取其子集
        /*
        public NavigableMap<K,V> subMap(K fromKey,boolean fromInclusive,
                                K toKey,boolean toInclusive)
                    返回此映射的部分视图，其键的范围从 fromKey 到 toKey。
        public SortedMap<K,V> subMap(K fromKey,K toKey)
                    返回此映射的部分视图，其键值的范围从 fromKey（包括）到 toKey（不包括）。（
        public SortedMap<K,V> tailMap(K fromKey)
                    返回此映射的部分视图，其键大于等于 fromKey。
        public NavigableMap<K,V> tailMap(K fromKey,boolean inclusive)
                    返回此映射的部分视图，其键大于（或等于，如果 inclusive 为 true）fromKey。
        public SortedMap<K,V> headMap(K toKey)
                    返回此映射的部分视图，其键值严格小于 toKey。
        public NavigableMap<K,V> headMap(K toKey,boolean inclusive)
                    返回此映射的部分视图，其键小于（或等于，如果 inclusive 为 true）toKey。
        * */
        NavigableMap<Integer, String> sm = tm1.subMap(0,true,3,false);
        Set<Integer> ssm = sm.keySet();
        System.out.println("subMap:");
        for(Integer s:ssm){
            System.out.println(s+":"+tm1.get(s));
            //subMap:
            //1:hello1
            //2:hello2
        }
        System.out.println("---------------------------");


        //public Comparator<? super K> comparator()
        //返回对此映射中的键进行排序的比较器；如果此映射使用键的自然顺序，则返回 null。
        Comparator c1 = tm1.comparator();
        Comparator c2 = tm2.comparator();
        System.out.println("comparator:"+c1+":"+c2); //null:javabase.map.TreeMapDemo02$1@4c98385c

        System.out.println("---------------------------");
    }
}
