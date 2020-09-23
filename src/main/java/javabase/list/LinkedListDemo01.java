package javabase.list;

import java.util.LinkedList;
/*
* LinkedList:用LinkedList模拟栈数据结构
* */
public class LinkedListDemo01 {
    public static void main(String[] args){

        MyStack ms = new MyStack();

        ms.add("hello");
        ms.add("world");
        ms.add("java");

        while(!ms.isEmpty()){
            System.out.println(ms.get());
        }
    }
    public static class MyStack {
        private LinkedList link;

        public MyStack() {
            link = new LinkedList();
        }

        public void add(Object obj) {
            link.addFirst(obj);
        }

        public Object get() {
            // return link.getFirst();
            return link.removeFirst();
        }

        public boolean isEmpty() {
            return link.isEmpty();
        }
    }
}
