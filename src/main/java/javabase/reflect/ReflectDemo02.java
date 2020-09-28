package javabase.reflect;

import java.lang.reflect.Constructor;
/*
* 通过反射获取构造方法并使用：public构造方法
* */
public class ReflectDemo02 {
    public static void main(String[] args) throws Exception {
        // 获取字节码文件对象
        Class c = Class.forName("javabase.reflect.Person");

        // 获取所有公共构造方法
         Constructor[] conss = c.getConstructors();

        for(Constructor con:conss){
            System.out.println(con);
            //public javabase.reflect.Person(java.lang.String,int,java.lang.String)
            //public javabase.reflect.Person()
        }

        System.out.println("-----------------------------------------");

        // 获取单个指定公共构造方法
        Class[] param = new Class[] { String.class, int.class, String.class };
        Constructor con = c.getConstructor(param);// 返回的是构造方法对象

        // 相当于 Person p = new Person();System.out.println(p);
        Object obj = con.newInstance("tom",11,"china");
        System.out.println(obj); //Person [name=tom, age=11, address=china]

        Person p = (Person)obj;
        p.show();  // show

    }
}
