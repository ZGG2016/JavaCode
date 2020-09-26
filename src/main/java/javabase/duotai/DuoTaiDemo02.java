package javabase.duotai;
/*
* 多态中的成员访问特点:
*      构造方法：子类的构造都会默认访问父类无参构造
* */
public class DuoTaiDemo02 {
    public static void main(String[] args) {
        Fu f = new Zi();
        //show Fu
        //show Zi
    }

    static class Fu {
        public Fu(){
            System.out.println("show Fu");
        }
        public Fu(int age){
            System.out.println("show Fu age");
        }
    }
    static class Zi extends Fu {

        public Zi(){
            System.out.println("show Zi");
        }

        public Zi(int age){
            System.out.println("show Zi age");
        }
    }
}
