package jianzhioffer.part3;


public class test5 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null) return null;

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int c1 = 0;
        int c2 = 0;

        while(p1.next!=null){
            p1 = p1.next;
            c1++;
        }

        while(p2.next!=null){
            p2 = p2.next;
            c2++;
        }
        p1 = pHead1;
        p2 = pHead2;
        if(c1>c2){
             int d = c1-c2;
             while(d!=0){
                p1 = p1.next;
                d--;
             }
        }else{
             int d = c2-c1;
            while(d!=0){
                p2 = p2.next;
                d--;
            }
        }
        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
