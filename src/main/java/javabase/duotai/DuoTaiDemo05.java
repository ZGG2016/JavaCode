package javabase.duotai;

public class DuoTaiDemo05 {
    public static void main(String[] args) {
        //测试
        Fu f = new Zi();
        f.show();  //show zi
        //f.method();  //报错

        //1.创建子类对象。(可以，但是很多时候不合理。而且，太占内存了)
        //Zi z = new Zi();
        //z.show();
        //z.method();

        //2.你能够把子的对象赋值给父亲，那么我能不能把父的引用赋值给子的引用呢?
        //如果可以，但是如下
        Zi z = (Zi)f;
        z.show(); //show zi
        z.method(); //method zi
    }

    static class Fu {
        public void show() {
            System.out.println("show fu");
        }
    }

    static class Zi extends Fu {
        public void show() {
            System.out.println("show zi");
        }

        public void method() {
            System.out.println("method zi");
        }

    }
}
