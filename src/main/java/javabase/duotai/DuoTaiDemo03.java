package javabase.duotai;
/*
 * 多态中的成员访问特点:
 *      成员方法：编译看左边，运行看右边（编译是否成功看左边，运行的结果看左边）
 * */
public class DuoTaiDemo03 {
    public static void main(String[] args) {
        Fu f = new Zi();
        f.show(); //show Zi
        //编译报错：找不到符号
        //f.method();
    }

    static class Fu {
        public void show() {
            System.out.println("show Fu");
        }
    }

    static class Zi extends Fu {
        public void show() {
            System.out.println("show Zi");
        }
        public void method() {
            System.out.println("method zi");
        }
    }
}
