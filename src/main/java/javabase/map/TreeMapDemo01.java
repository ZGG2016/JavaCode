package javabase.map;

import java.util.Comparator;
import java.util.TreeMap;
/*
* TreeMap:构造方法
* */
public class TreeMapDemo01 {
    public static void main(String[] args) {
        // 1.构造方法。具体描述见api

        //（1）public TreeMap()使用键的自然顺序构造一个新的、空的树映射。
        TreeMap<String, String> tm1 = new TreeMap<String, String>();
/*
  （2）public TreeMap(Map<? extends K,? extends V> m)
      构造一个与给定映射具有相同映射关系的新的树映射，该映射根据其键的自然顺序 进行排序。
  （3）public TreeMap(SortedMap<K,? extends V> m)
      构造一个与指定有序映射具有相同映射关系和相同排序顺序的新的树映射。
 */

    //public TreeMap(Comparator<? super K> comparator)
    // 构造一个新的、空的树映射，该映射根据给定比较器进行排序。

        TreeMap<String, String> tm2 = new TreeMap<String, String>(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.length()-o2.length();
                    }
                }
        );

        // 创建元素并添加元素
        tm1.put("c", "你好");
        tm1.put("bbb", "世界");
        tm1.put("aa", "爪哇");
        tm1.put("ddd", "爪哇EE");

        tm2.put("aaaa", "你好");
        tm2.put("b", "世界");
        tm2.put("ccc", "爪哇");
        tm2.put("dd", "爪哇EE");

        System.out.println(tm1); //{aa=爪哇, bbb=世界, c=你好, ddd=爪哇EE}
        System.out.println("----------------");
        System.out.println(tm2); //{b=世界, dd=爪哇EE, ccc=爪哇, aaaa=你好}

    }
}
