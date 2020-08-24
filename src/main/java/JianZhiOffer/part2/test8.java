package JianZhiOffer.part2;

import java.util.Arrays;

public class test8 {
    //采用阵地攻守的思想：
    //第一个数字作为第一个士兵，守阵地；count = 1；
    //遇到相同元素，count++;
    //遇到不相同元素，即为敌人，同归于尽,count--；当遇到count为0的情况，又以新的i值作为守阵地的士兵，
    // 继续下去，到最后还留在阵地上的士兵，有可能是主元素。
    //再加一次循环，记录这个士兵的个数看是否大于数组一般即可
    public int MoreThanHalfNum_Solution1(int [] array) {
        int len = array.length;
        if(len == 0) return 0;

        int rlt = array[0];
        int time = 1;
        for(int i=1;i<len;i++){

            if(time==0){
                rlt = array[i];
                time=1;
            }else{
                if(rlt==array[i]){
                    time++;
                }else{
                    time--;
                }
            }
        }

        time=0;
        for(int i=0;i<len;i++){
            if(rlt==array[i]){
                time++;
            }
        }

        if(time*2<=len){
            rlt=0;
        }

        return rlt;
    }

    //数组排序后，如果符合条件的数存在，则一定是数组中间那个数
    public int MoreThanHalfNum_Solution2(int [] array) {
        Arrays.sort(array);
        int count=0;

        for(int i=0;i<array.length;i++){
            if(array[i]==array[array.length/2]){
                count++;
            }
        }
        if(count>array.length/2){
            return array[array.length/2];
        }else{
            return 0;
        }

    }
}