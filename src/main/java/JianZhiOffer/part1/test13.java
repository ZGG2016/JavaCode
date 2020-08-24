package JianZhiOffer.part1;

import java.util.LinkedList;
import java.util.Queue;

public class test13 {
    public void reOrderArray1(int [] array) {
        Queue<Integer> odd = new LinkedList<Integer>();
        Queue<Integer> even = new LinkedList<Integer>();

        for(int a:array){
            if(a%2==0){
                even.offer(a);
            }else{
                odd.offer(a);
            }
        }

        for(int i=0;i<array.length;){
            while(!odd.isEmpty()){
                array[i]=odd.poll();
                i++;
            }
            while(!even.isEmpty()){
                array[i]=even.poll();
                i++;
            }
        }
    }

    public void reOrderArray3(int [] array) {  //²åÈëÅÅÐò
        for(int i=0;i<array.length;i++){
            if(array[i]%2!=0){
                for(int j=i;j>0;j--){
                    if (array[j - 1] % 2 == 0){
                        int t = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = t;
                    }
                }
            }
        }
    }

    public void reOrderArray2(int [] array) {
        Queue<Integer> q = new LinkedList<Integer>();
        for(int a:array){
            if(a%2!=0){
                q.offer(a);
            }
        }
        for(int a:array){
            if(a%2==0){
                q.offer(a);
            }
        }
        for(int i=0;i<array.length;i++){
            array[i]=q.poll();
        }
    }
}
