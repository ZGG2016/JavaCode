package javabase.codeblock;
/*
   10
   20
   ---------------
   1000
   2000
   100
   200
   code
   ---------------
   100
   200
   code
   ---------------
   100
   200
   code
  */
public class CodeBlockDemo01 {
    public static void main(String[] args) {
        //局部代码块
        {
            int x = 10;
            System.out.println(x);
        }
        //找不到符号
        //System.out.println(x);
        {
            int y = 20;
            System.out.println(y);
        }
        System.out.println("---------------");

        Code c = new Code();
        System.out.println("---------------");
        Code c2 = new Code();
        System.out.println("---------------");
        Code c3 = new Code(1);

    }

    static class Code {
        static {
            int a = 1000;
            System.out.println(a);
        }

        //构造代码块
        {
            int x = 100;
            System.out.println(x);
        }

        //构造方法
        public Code(){
            System.out.println("code");
        }

        //构造方法
        public Code(int a){
            System.out.println("code");
        }

        //构造代码块
        {
            int y = 200;
            System.out.println(y);
        }

        //静态代码块
        static {
            int b = 2000;
            System.out.println(b);
        }
    }
}
