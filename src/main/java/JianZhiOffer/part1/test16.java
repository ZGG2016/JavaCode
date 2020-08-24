package JianZhiOffer.part1;

public class test16 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;

        ListNode mergeHead = null;
        ListNode cur = null;

        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                if(mergeHead==null){
                    mergeHead = list1;
                    cur = list1;
                }else{
                    cur.next = list1;
                    cur = cur.next;
                }
                list1 = list1.next;
            }else{
                if(mergeHead==null){
                    mergeHead = list2;
                    cur = list2;
                }else{
                    cur.next = list2;
                    cur = cur.next;
                }
                list2 = list2.next;
            }
        }

        if(list1==null){
            cur.next = list2;
        }else{
            cur.next = list1;
        }
        return mergeHead;
    }

    public ListNode Merge2(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }
}
