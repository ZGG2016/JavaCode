package javabase.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * Map:获取方法（遍历）
 * */
public class MapDemo02 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("邓超", "孙俪");
        map.put("黄晓明", "杨颖");
        map.put("周杰伦", "蔡依林");
        map.put("刘恺威", "杨幂");

        // V get(Object key):返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。
        //如果此映射允许 null 值，则返回 null 值并不一定 表示该映射不包含该键的映射关系；
        // 也可能该映射将该键显示地映射到 null。使用 containsKey 操作可区分这两种情况。
        System.out.println("get:" + map.get("周杰伦"));
        System.out.println("get:" + map.get("周杰")); // 返回null
        System.out.println("----------------------");

        // Collection<V> values():获取集合中所有值的集合
        Collection<String> con = map.values();
        for (String value : con) {
            System.out.println(value);
        }
        System.out.println("----------------------");

        /*
        * 遍历：
        *   1.Set<K> keySet()：获取集合中所有键的集合
        *   2.Set<Map.Entry<K,V>> entrySet()：返回的是键值对对象的集合
        * */

        // Set<K> keySet()
        Set<String> set = map.keySet();
        for (String key : set) {
            System.out.println(key+":"+map.get(key));
        }

        System.out.println("----------------------");

        //Set<Map.Entry<K,V>> entrySet()
        Set<Map.Entry<String, String>> setm = map.entrySet();
        for (Map.Entry<String, String> me : setm) {
            // 根据键值对对象获取键和值
            String key = me.getKey();
            String value = me.getValue();
            if(key.equals("邓超")){
                me.setValue("aaa");
            }

            System.out.println(key + "---" + me.getValue());  //邓超---aaa
        }
    }
}
