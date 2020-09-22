package jianzhioffer.part2;

public class test10 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int curMax=array[0];
        int max=array[0];
        for(int i=1;i<array.length;i++){
            curMax = Math.max(curMax+array[i],array[i]);
            max = Math.max(curMax,max);
        }
        return max;
    }
}
