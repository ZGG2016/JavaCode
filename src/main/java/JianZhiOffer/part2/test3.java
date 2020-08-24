package JianZhiOffer.part2;

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

        //复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
        RandomListNode currentNode  = pHead;
        while(currentNode !=null){
            RandomListNode cloneNode  = new RandomListNode(currentNode .label);
            cloneNode .next = currentNode .next;
            currentNode .next = cloneNode ;
            currentNode  = cloneNode .next;  //注意
        }
        //重新遍历链表，复制老结点的随机指针给新结点
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
