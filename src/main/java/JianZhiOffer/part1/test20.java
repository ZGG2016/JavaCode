package JianZhiOffer.part1;

import java.util.ArrayList;
import java.util.Stack;

public class test20 {

    Stack<Integer> stack=new Stack<>();
    Stack<Integer> minNum=new Stack<>();

    public void push(int node) {
        stack.push(node);
        if(minNum.isEmpty()) minNum.push(stack.peek()); //Java中获取栈顶:peek()
        else if(stack.peek()<minNum.peek()) minNum.push(stack.peek());
        else minNum.push(minNum.peek());
    }

    public void pop() {
        stack.pop();
        minNum.pop();//同步弹出元素
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return  minNum.peek();
    }


//    ArrayList<Integer> list = new ArrayList<Integer>();
//
//    public void push(int node) {
//        list.add(0,node);
//    }
//
//    public void pop() {
//        list.remove(0);
//    }
//
//    public int top() {
//        return list.get(0);
//    }
//
//    public int min() {
//        int temp = top();
//        for(int i=1;i<list.size();i++){
//            if(temp>list.get(i)){
//                temp = list.get(i);
//            }
//        }
//        return temp;
//    }
}
