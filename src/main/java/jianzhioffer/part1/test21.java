package jianzhioffer.part1;

import java.util.ArrayList;
import java.util.Stack;

public class test21 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0) return false;
        int indexpop = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);  //�ҵ�stack��ջ��Ԫ�غ�popA�ĵ�һ��Ԫ�����
            while(!stack.isEmpty() && stack.peek()==popA[indexpop]){
                stack.pop();
                indexpop++;
            }
        }
        return stack.isEmpty();
    }
    //������
    public boolean IsPopOrder2(int [] pushA,int [] popA) {
        if(pushA.length==0||popA.length==0)
            return false;
        ArrayList<Integer> list  = new ArrayList<Integer>();
        int j = 0;
        for(int i = 0;i<pushA.length;i++){
            if(pushA[i]!=popA[j])
                list.add(pushA[i]);
            else
                j++;
        }
        for(int i = list.size()-1;i>=0;i--){
            if(list.get(i)!=popA[j])
                return false;
            j++;
        }
        return true;
    }
}
