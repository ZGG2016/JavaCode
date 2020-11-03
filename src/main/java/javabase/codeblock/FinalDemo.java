package javabase.codeblock;

public class FinalDemo {
    public static void main(String[] args) {
        Demo d = new Demo();
        System.out.println(d.num); //100
        System.out.println(d.num2); //10
    }

    static class Demo {
        //int num = 10;
        //final int num2 = 20;

        int num;
        final int num2;

        {
            num2 = 10;
        }

        public Demo() {
            num = 100;
            //无法为最终变量num2分配值
//            num2 = 200;
        }
    }
}
