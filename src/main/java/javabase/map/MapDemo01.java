package javabase.map;

import java.util.HashMap;
import java.util.Map;
/*
* Map:基础方法测试
* */
public class MapDemo01 {
    public static void main(String[] args) {
        // 创建集合对象
        Map<String, String> map = new HashMap<String, String>();

        // 添加元素
        // V put(K key,V value):添加元素。如果此映射以前包含一个该键的映射关系，则用指定值替换旧值
        //返回以前与 key 关联的值，如果没有针对 key 的映射关系，则返回 null。
        System.out.println("put:" + map.put("文章", "马伊俐"));  //put:null
        System.out.println("put:" + map.put("文章", "姚笛")); //put:马伊俐

        map.put("邓超", "孙俪");
        map.put("黄晓明", "杨颖");
        map.put("周杰伦", "蔡依林");
        map.put("刘恺威", "杨幂");

        // void clear():移除所有的键值对元素
        // map.clear();

        // V remove(Object key)：根据键删除键值对元素，并把值返回
        //返回此映射中以前关联该键的值，如果此映射不包含该键的映射关系，则返回 null。
         System.out.println("remove:" + map.remove("黄晓明"));  //remove:杨颖
         System.out.println("remove:" + map.remove("黄晓波"));  //remove:null

        // boolean containsKey(Object key)：判断集合是否包含指定的键
         System.out.println("containsKey:" + map.containsKey("黄晓明")); //containsKey:false
         System.out.println("containsKey:" + map.containsKey("黄晓波")); //containsKey:false

        // boolean isEmpty()：判断集合是否为空
         System.out.println("isEmpty:"+map.isEmpty()); //isEmpty:false

        //int size()：返回集合中的键值对的对数
        System.out.println("size:"+map.size()); //size:4

        // 输出集合名称
        System.out.println("map:" + map); //map:{邓超=孙俪, 文章=姚笛, 周杰伦=蔡依林, 刘恺威=杨幂}

    }
}
