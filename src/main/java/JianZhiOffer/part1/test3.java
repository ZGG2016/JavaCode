package JianZhiOffer.part1;

import java.util.ArrayList;
import java.util.Stack;

public class test3 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode){
        ArrayList<Integer>  al = new ArrayList<Integer>();
        if(listNode==null) return al;

        Stack<Integer> stack = new Stack<Integer>();

        ListNode tmp = listNode;
        while(tmp!=null){
            stack.push(tmp.val);
            tmp = tmp.next;
        }

        while(!stack.isEmpty()){
            al.add(stack.pop());
        }
        return al;
    }


    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
            if(listNode!=null){
                this.printListFromTailToHead2(listNode.next);
                arrayList.add(listNode.val);
            }
            return arrayList;
        }

}
