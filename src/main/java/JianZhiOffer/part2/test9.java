package JianZhiOffer.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class test9 {
    public static void main(String[] args){
        int[] arr = {4,5,1,6,2,7,2,8};
        ArrayList<Integer> list = new ArrayList<Integer>();
        list = GetLeastNumbers_Solution(arr,2);
        for(Integer x:list){
            System.out.println(x);
        }
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        int len = input.length;
        if(k>len || k<=0) return new ArrayList<Integer>();

        ArrayList<Integer> al = new ArrayList<Integer>();

        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(input[i]>=input[j] && !al.contains(input[j])){
                    al.add(input[j]);
                }
            }
            if(al.size()==k){
                break;
            }
            al.clear();
        }
        return al;
    }
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        Arrays.sort(input);//快速排序
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(k>input.length|k<=0){//判断是否存在越界
            return list;
        }else{for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
            return list;
        }
    }
    public ArrayList<Integer> GetLeastNumbers_Solution3(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (k > input.length) {
            return res;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new MyComparator());
        for (int i = 0; i < input.length; i++) {
            queue.add(input[i]);
        }
        while (k>0) {
            res.add(queue.poll());
            k--;
        }
        return res;
    }

    public class MyComparator implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            // TODO Auto-generated method stub
            return o1 - o2;
        }
    }
}