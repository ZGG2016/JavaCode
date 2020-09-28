package javabase.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodDemo {
    public static void main(String[] args) throws Exception{

        Class c = Class.forName("javabase.reflect.Person");
        Method m = c.getMethod("show");


        //public Class<?> getDeclaringClass()返回表示声明由此 Method 对象表示的方法的类或接口的 Class 对象。
        //getDeclaringClass:class javabase.reflect.Person
        System.out.println("getDeclaringClass:"+m.getDeclaringClass());

        //public String getName()以 String 形式返回此 Method 对象表示的方法名称。
        System.out.println("getName:"+m.getName()); //getName:show

        //public int getModifiers()以整数形式返回此 Method 对象所表示方法的 Java 语言修饰符。
        System.out.println("getModifiers:"+m.getModifiers()); //getModifiers:1

        //public TypeVariable<Method>[] getTypeParameters()
        // 返回 TypeVariable 对象的数组，
        // 这些对象描述了由 GenericDeclaration 对象表示的一般声明按声明顺序来声明的类型变量。
        //getTypeParameters:[]
        System.out.println("getTypeParameters:"+ Arrays.toString(m.getTypeParameters()));

        //public Class<?> getReturnType()
        // 返回一个 Class 对象，该对象描述了此 Method 对象所表示的方法的正式返回类型。
        System.out.println("getReturnType:"+m.getReturnType()); //getReturnType:void

        //public Type getGenericReturnType()返回表示由此 Method 对象所表示方法的正式返回类型的 Type 对象。
        System.out.println("getGenericReturnType:"+m.getGenericReturnType()); //getGenericReturnType:void

        //public Class<?>[] getParameterTypes()
        // 按照声明顺序返回 Class 对象的数组，这些对象描述了此 Method 对象所表示的方法的形参类型。
        System.out.println("getParameterTypes:"+ Arrays.toString(m.getParameterTypes()));//getParameterTypes:[]

        //public Type[] getGenericParameterTypes()
        // 按照声明顺序返回 Type 对象的数组，这些对象描述了此 Method 对象所表示的方法的形参类型的。
        System.out.println("getGenericParameterTypes:"+ Arrays.toString(m.getGenericParameterTypes()));//getGenericParameterTypes:[]

        //public String toString()返回描述此 Method 的字符串。
        //public String toGenericString()返回描述此 Method 的字符串，包括类型参数。
        //toString:public void javabase.reflect.Person.show()
        //toGenericString:public void javabase.reflect.Person.show()
        System.out.println("toString:"+m.toString());
        System.out.println("toGenericString:"+m.toGenericString());


        //public Object invoke(Object obj,Object... args)
        // 对带有指定参数的指定对象调用由此 Method 对象表示的底层方法。
        Constructor con = c.getConstructor();
        Person p = (Person) con.newInstance();        m.invoke(p); //show

    }
}
