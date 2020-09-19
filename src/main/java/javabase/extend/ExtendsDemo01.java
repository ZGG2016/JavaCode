package javabase.extend;

public class ExtendsDemo01 {
    public static void main(String[] args) {
        //创建对象
        Son s = new Son();
        s.show();
    }

     static class Father {
        public int num = 10;
        public int num4 = 100;

        public void method() {
            int num = 50;
        }
    }

     static class Son extends Father{
        public int num2 = 20;
        public int num = 30;

        public void show() {
            int num = 40;
            System.out.println(num); //40、30、10
            System.out.println(num2);//20
            // 找不到符号
            //System.out.println(num3);

            System.out.println(num4); //100
        }
    }

}
