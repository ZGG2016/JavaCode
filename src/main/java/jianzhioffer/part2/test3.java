package jianzhioffer.part2;

public class test3 {


    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead){

        if(pHead==null) return null;

        //����next ��ԭ����A->B->C ���A->A'->B->B'->C->C'
        RandomListNode currentNode  = pHead;
        while(currentNode !=null){
            RandomListNode cloneNode  = new RandomListNode(currentNode .label);
            cloneNode .next = currentNode .next;
            currentNode .next = cloneNode ;
            currentNode  = cloneNode .next;  //ע��
        }
        //���±������������Ͻ������ָ����½��
        currentNode  = pHead;
        while(currentNode!=null){
            if(currentNode.random!=null){
                currentNode.next.random = currentNode.random.next;
            }
            currentNode = currentNode.next.next;

        }

        currentNode  = pHead;
        RandomListNode head = pHead.next;
        RandomListNode cur = head;
        while(currentNode!=null){
            currentNode.next = currentNode.next.next;
            if(cur.next!=null){
                cur.next = cur.next.next;
            }
            currentNode = currentNode.next;
            cur = cur.next;

        }
        return head;
    }

}
