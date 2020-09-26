package javabase.duotai;
/*
* 多态中的成员访问特点:
*      成员变量：编译看左边，运行看左边（编译是否成功看左边，运行的结果看左边）
* */
public class DuoTaiDemo01 {
    public static void main(String[] args) {
        //要有父类引用指向子类对象。
        Fu f = new Zi();
        System.out.println(f.num); //100
        //编译报错：找不到符号
//        System.out.println(f.num2);
    }

    static class Fu {
        public int num = 100;
    }

    static class Zi extends Fu {
        public int num = 1000;
        public int num2 = 200;
    }
}
