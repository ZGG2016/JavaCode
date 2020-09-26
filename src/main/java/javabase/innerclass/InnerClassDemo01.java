package javabase.innerclass;
/*
* 内部类的访问规则
	A:可以直接访问外部类的成员，包括私有
	B:外部类要想访问内部类成员，必须创建对象
* */
public class InnerClassDemo01 {
    public static void main(String[] args) {
        InnerClassDemo01 outer = new InnerClassDemo01();
        outer.method(); //10
    }

    private int num = 10;

    class Inner {
        public void show() {
            System.out.println(num);
        }
    }

    public void method() {
        //找不到符号
//        show();

        Inner i = new Inner();
        i.show();
    }
}
