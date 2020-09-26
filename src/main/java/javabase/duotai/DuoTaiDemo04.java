package javabase.duotai;
/*
 * 多态中的成员访问特点:
 *      静态方法：编译看左边，运行看左边
 * */
public class DuoTaiDemo04 {
    public static void main(String[] args) {
        Fu f = new Zi();
        f.function(); //function Fu
    }

    static class Fu {
        public static void function() {
            System.out.println("function Fu");
        }
    }

    static class Zi extends Fu {
        public static void function() {
            System.out.println("function Zi");
        }
    }

}
