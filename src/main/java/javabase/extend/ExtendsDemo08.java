package javabase.extend;

public class ExtendsDemo08 {
    public static void main(String[] args) {
        NewPhone np = new NewPhone();
        np.call("林青霞");
    }

    static class Phone {
        public void call(String name) {
            System.out.println("给"+name+"打电话");
        }
    }

    static class NewPhone extends Phone {
        public void call(String name) {
            //System.out.println("给"+name+"打电话");
            super.call(name);
            System.out.println("可以听天气预报了");
        }
    }

}
