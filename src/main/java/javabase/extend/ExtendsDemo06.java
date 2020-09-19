package javabase.extend;

public class ExtendsDemo06 {
    public static void main(String[] args) {
        //创建对象
        Son s = new Son();
        s.show(); //show Son
        s.method(); //method Son
        //s.fucntion(); //找不到符号
    }

    static class Father {
        public void show() {
            System.out.println("show Father");
        }
    }

    static class Son extends Father {
        public void method() {
            System.out.println("method Son");
        }

        public void show() {
            System.out.println("show Son");
        }
    }
}
