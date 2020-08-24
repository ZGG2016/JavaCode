package JianZhiOffer.part1;

public class test6 {
    /*
    * 理解题目：
    *       首先是找出数组的最小元素
    *       然后 题目的前部分是介绍数组的特征
    *
    * */
    public int minNumberInRotateArray1(int [] array) {
        if(array.length==0) return 0;

        for(int i=0;i<array.length-1;i++){
            if(array[i]>array[i+1]){
                return array[i+1];
            }
        }
        return array[0];
    }
    public int minNumberInRotateArray2(int [] array) {
        if(array.length==0) return 0;

        int lo=0;
        int hi=array.length-1;
        int mid=0;
        while(array[lo]>=array[hi]){ //始终满足条件
            if(hi-lo==1){
                mid=hi;
                break;
            }
            mid = lo+(hi-lo)/2;
            if (array[mid] >= array[lo]) {
                lo = mid;
            }
            if (array[mid] <= array[hi]) {
                hi = mid;
            }
        }
        return array[mid];
    }
}
