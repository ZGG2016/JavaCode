package javabase.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class FieldDemo {
    public static void main(String[] args) throws Exception{
        Class c = Class.forName("javabase.reflect.Person");

        Constructor con = c.getConstructor();
        Person p = (Person) con.newInstance();

        Field f = c.getField("address");
        f.setAccessible(true);

        //public Class<?> getDeclaringClass()
        // 返回表示类或接口的 Class 对象，该类或接口声明由此 Field 对象表示的字段。
        //getDeclaringClass:class javabase.reflect.Person
        System.out.println("getDeclaringClass:"+f.getDeclaringClass());

        //public String getName()返回此 Field 对象表示的字段的名称。
        System.out.println("getName:"+f.getName()); //getName:address

        //public int getModifiers()以整数形式返回由此 Field 对象表示的字段的 Java 语言修饰符。
        System.out.println("getModifiers:"+f.getModifiers());   //getModifiers:1

        //public Class<?> getType()返回一个 Class 对象，它标识了此 Field 对象所表示字段的声明类型。
        //getType:class java.lang.String
        System.out.println("getType:"+f.getType());

        //public Type getGenericType()返回一个 Type 对象，它表示此 Field 对象所表示字段的声明类型。
        //getGenericType:class java.lang.String
        System.out.println("getGenericType:"+f.getGenericType());

        //public Object get(Object obj)返回指定对象上此 Field 表示的字段的值。
        System.out.println("get:"+f.get(p));  //get:beijing

        //public int getInt(Object obj)  字段的值
        // 获取 int 类型或另一个通过扩展转换可以转换为 int 类型的基本类型的 静态或实例字段的值。
        System.out.println(c.getDeclaredField("age").getInt(p)); //11

        //public void set(Object obj,Object value)
        // 将指定对象变量上此 Field 对象表示的字段设置为指定的新值。
        f.set(p,"shanghai");
        System.out.println("getName:"+f.get(p)); //getName:shanghai

        //public void setInt(Object obj, int i)
        // 将字段的值设置为指定对象上的一个 int 值。
        // 该方法等同于 set(obj, iObj)，其中 iObj 是一个 Integer 对象，并且 iObj.intValue() == i。
        c.getDeclaredField("age").setInt(p,22);
        System.out.println(c.getDeclaredField("age").getInt(p)); //2
    }
}
