package jianzhioffer.part5;

import java.util.Comparator;
import java.util.PriorityQueue;

public class test6 {

    int count;
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            //PriorityQueueĬ����С���ѣ�ʵ�ִ󶥶ѣ���Ҫ��תĬ��������
            return o2.compareTo(o1);
        }
    });

    public void Insert(Integer num) {
        count++;
        if (count%2 == 0) { // �ж�ż���ĸ�Чд��
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        } else {
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        if(count==0)
            throw new RuntimeException("no available number!");
        double result;
        //����Ϊ����ʱ���󶥶ѶѶ�������λ��
        if((count&1)==1)
            result=maxHeap.peek();
        else
            result=(minHeap.peek()+maxHeap.peek())/2.0;
        return result;
    }
}
