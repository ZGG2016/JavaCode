import com.google.common.collect.Multiset;
import org.apache.commons.collections.Bag;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class test {
    public static void main(String[] args){
        Queue<Integer> q = new LinkedList<Integer>();

        Integer[] a = q.toArray(new Integer[0]);
    }
    static class MinStack {

        Queue<Integer> queue1 = null;
        Queue<Integer> queue2 = null;

        /** initialize your data structure here. */
        public MinStack() {
            queue1 = new LinkedList<Integer>();
            queue2 = new LinkedList<Integer>();
        }

        public void push(int x) {
            queue1.offer(x);
            while(queue1.size()!=0){
                queue2.offer(queue2.poll());
            }
        }

        public void pop() {
            queue2.poll();
        }

        public int top() {
            return queue2.peek();
        }

        public int min() {
            Integer[] arr = queue2.toArray(new Integer[0]);
            Arrays.sort(arr);
            return arr[0];
        }
    }
}
