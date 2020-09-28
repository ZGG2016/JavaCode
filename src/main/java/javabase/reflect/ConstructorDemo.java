package javabase.reflect;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class ConstructorDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class c = Class.forName("javabase.reflect.Person");
        Class[] param = new Class[] { String.class, int.class, String.class };
        Constructor con = c.getConstructor(param);

        //public Class<T> getDeclaringClass()
        // 返回 Class 对象，该对象表示声明由此 Constructor 对象表示的构造方法的类。
        //getDeclaringClass:class javabase.reflect.Person
        System.out.println("getDeclaringClass:"+con.getDeclaringClass());

        //public String getName() 以字符串形式返回此构造方法的名称。它总是与构造方法的声明类的简单名称相同。
        //getName:javabase.reflect.Person
        System.out.println("getName:"+con.getName());

        //public int getModifiers()
        // 以整数形式返回此 Constructor 对象所表示构造方法的 Java 语言修饰符。
        // 应该使用 Modifier 类对这些修饰符进行解码。
        //getModifiers:1
        //public static final int PUBLIC 1
        //public static final int PRIVATE 2
        System.out.println("getModifiers:"+con.getModifiers());

        //public TypeVariable<Constructor<T>>[] getTypeParameters()
        // 按照声明顺序返回一组 TypeVariable 对象，这些对象表示通过此 GenericDeclaration 对象所表示的一般声明来声明的类型变量。
        //getTypeParameters:[]
        System.out.println("getTypeParameters:"+ Arrays.toString(con.getTypeParameters()));

        //public Class<?>[] getParameterTypes() 参数的类型
        // 按照声明顺序返回一组 Class 对象，这些对象表示此 Constructor 对象所表示构造方法的形参类型。
        //getParameterTypes:[class java.lang.String, int, class java.lang.String]
        System.out.println("getParameterTypes:"+ Arrays.toString(con.getParameterTypes()));

        //public Type[] getGenericParameterTypes()
        // 按照声明顺序返回一组 Type 对象，这些对象表示此 Constructor 对象所表示的方法的形参类型。
        //getGenericParameterTypes:[class java.lang.String, int, class java.lang.String]
        System.out.println("getGenericParameterTypes:"+ Arrays.toString(con.getGenericParameterTypes()));

        //public String toGenericString()返回描述此 Constructor 的字符串，其中包括类型参数。
        //toGenericString:public javabase.reflect.Person(java.lang.String,int,java.lang.String)
        System.out.println("toGenericString:"+con.toGenericString());
        System.out.println("toString:"+con.toString());
    }
}
