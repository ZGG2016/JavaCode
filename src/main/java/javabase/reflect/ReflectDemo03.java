package javabase.reflect;

import java.lang.reflect.Constructor;
/*
 * 通过反射获取构造方法并使用：所有构造方法（包含private）
 * */
public class ReflectDemo03 {
    public static void main(String[] args) throws Exception {
        // 获取字节码文件对象
        Class c = Class.forName("javabase.reflect.Person");

        // 所有构造方法
         Constructor[] cons = c.getDeclaredConstructors();
         for (Constructor con : cons) {
            System.out.println(con);
            //public javabase.reflect.Person(java.lang.String,int,java.lang.String)
             //javabase.reflect.Person(java.lang.String,int)
             //private javabase.reflect.Person(java.lang.String)
             //public javabase.reflect.Person()
         }

        // 获取单个构造方法
        Class[] param = new Class[] { String.class };
        Constructor con = c.getDeclaredConstructor(param);// 返回的是构造方法对象
        con.setAccessible(true);

        // 相当于 Person p = new Person();System.out.println(p);
        Object obj = con.newInstance("tom");
        System.out.println(obj); //Person [name=tom, age=0, address=null]

        Person p = (Person)obj;
        p.show(); //show
    }
}
