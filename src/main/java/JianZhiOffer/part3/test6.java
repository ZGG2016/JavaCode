package JianZhiOffer.part3;

import java.util.Arrays;
import java.util.HashMap;

public class test6 {

    public int GetNumberOfK1(int [] array , int k) {
        if (array.length == 0 || array[0] > k || array[array.length - 1] < k) return 0;

        int first = getFirstK(array,k,0,array.length-1);
        int last = getLastK(array,k,0,array.length-1);

        if(first != -1 && last != -1){
            return last - first + 1;
        }
        return 0;
    }
    private int getFirstK(int [] array , int k, int start, int end){
        int length = array.length;

        while(start <= end){
            int mid = (start + end) >> 1;
            if(array[mid] > k){
                end = mid-1;
            }else if(array[mid] < k){
                start = mid+1;
            }else{
                if(mid>0 && array[mid-1]!=k||mid==0){
                    return mid;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }
    private int getLastK(int [] array , int k, int start, int end){
        int length = array.length;

        while(start <= end){
            int mid = (start + end) >> 1;
            if(array[mid] > k){
                end = mid-1;
            }else if(array[mid] < k){
                start = mid+1;
            }else if(mid<length-1 && array[mid+1]!=k||mid==array.length-1){
                return mid;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }


    public int GetNumberOfK2(int [] array , int k) {
        if(array.length==0||array[0]>k || array[array.length-1]<k) return 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<array.length;i++){
            if(!hm.containsKey(array[i])){
                hm.put(array[i],1);
            }else{
                hm.put(array[i],hm.get(array[i])+1);
            }
        }
        for(int i=0;i<array.length;i++){
            if(k==array[i]){
                return hm.get(array[i]);
            }
        }
        return 0;
    }
}
