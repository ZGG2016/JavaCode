package javabase.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
/*
* 通过反射获取成员变量并使用
*
* */
public class ReflectDemo04 {
    public static void main(String[] args) throws Exception {
        // 获取字节码文件对象
        Class c = Class.forName("javabase.reflect.Person");

        // 获取所有的成员变量
        // Field[] fields = c.getFields();  //公共
        // Field[] fields = c.getDeclaredFields();  //所有
        // for (Field field : fields) {
        // System.out.println(field);
        // }


        // 通过无参构造方法创建对象
        Constructor con = c.getConstructor();
        Object obj = con.newInstance();
        System.out.println(obj); //Person [name=null, age=11, address=beijing]


        // 获取单个的成员变量
        // 获取address并对其赋值
        Field addressField = c.getField("address");
        // public void set(Object obj,Object value)
        // 将指定对象变量上此 Field 对象表示的字段设置为指定的新值。
        //Person [name=null, age=11, address=北京]
        addressField.set(obj, "北京"); // 给obj对象的addressField字段设置值为"北京"
        System.out.println(obj);

        // 获取name并对其赋值 (私有private字段)
        // NoSuchFieldException
        Field nameField = c.getDeclaredField("name");
        // IllegalAccessException
        nameField.setAccessible(true);
        nameField.set(obj, "林青霞");
        System.out.println(obj); //Person [name=林青霞, age=11, address=北京]

        // 获取age并对其赋值
        Field ageField = c.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(obj, 27);
        System.out.println(obj); //Person [name=林青霞, age=27, address=北京]
    }
}
