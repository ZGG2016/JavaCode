package javabase.reflect;
/*
 * 获取class文件对象的方式有：
 *      A:Object类的getClass()方法
 *      B:数据类型的静态属性class
 *      C:Class类中的静态方法：public static Class forName(String className)
 *
 * 开发选第三种
 * 	因为第三种是一个字符串，而不是一个具体的类名。这样我们就可以把这样的
 *	字符串配置到配置文件中。
 *
 */
public class ReflectDemo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 方式1
        Person p1 = new Person();
        Class class1 = p1.getClass();

        Person p2 = new Person();
        Class class2 = p2.getClass();

        System.out.println(p1==p2);  //false
        System.out.println(class1==class2);  //true
        // 方式2
        Class class3 = Person.class;
        System.out.println(class1==class3); //true
        // 方式3
        Class class4 = Class.forName("javabase.reflect.Person");
        System.out.println(class1==class4); //true


    }
}
