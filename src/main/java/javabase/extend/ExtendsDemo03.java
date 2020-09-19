package javabase.extend;

public class ExtendsDemo03 {
    public static void main(String[] args) {

        Son s = new Son();
        System.out.println("----------------");
        Son ss = new Son("林青霞");
        /*
          Father的带参构造方法
          Son的无参构造方法
          ----------------
          Father的带参构造方法
          Son的无参构造方法
          Son的带参构造方法
         */
    }

     static class Father {
        /*
         方法3：让父类提供无参构造。
        public Father() {
            System.out.println("Father的无参构造方法");
        }
        */

        public Father(String name) {
            System.out.println("Father的带参构造方法");
        }
    }

     static class Son extends Father {
        public Son() {
            super("随便给"); //方法1：子类通过super去明确调用带参构造。
            System.out.println("Son的无参构造方法");
        }

        public Son(String name) {
            //super("随便给");
            this(); //方法2：子类通过this调用本身的其他构造(这里就是Son的无参构造)
            System.out.println("Son的带参构造方法");
        }
    }
}
