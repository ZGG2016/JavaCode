package JianZhiOffer.part1;

import java.util.Stack;

public class test5 {
/*
*
* ��ӣ���Ԫ�ؽ�ջA
* ���ӣ��ж�ջB�Ƿ�Ϊ�գ����Ϊ�գ���ջA������Ԫ��pop����push��ջB��ջB��ջ��
*      �����Ϊ�գ�ջBֱ�ӳ�ջ��
*
* */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.empty()&&stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
