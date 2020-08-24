package JianZhiOffer.part1;

import java.util.Stack;

public class test14 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail1(ListNode head,int k) {
        if(head==null) return null;
        int count=0;
        Stack<ListNode> stack = new Stack<ListNode>();
        while(head!=null){
            stack.push(head);
            count++;
            head = head.next;
        }

        if(count<k){
            return null;
        }

        ListNode tmp = null;
        for(int i=0;i<k;i++){
            tmp = stack.pop();
        }
        return tmp;
    }

    public ListNode FindKthToTail2(ListNode head,int k){
        if(head==null || k<=0) return null;

        ListNode pre = head;
        ListNode after = head;

        for(int i=1;i<k;i++){
            if(pre.next!=null){
                pre = pre.next;
            }else{
                return null;
            }
        }

        while(pre.next!=null){
            pre = pre.next;
            after = after.next;
        }
        return after;
    }
}
