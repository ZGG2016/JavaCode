package jianzhioffer.part1;

import java.util.ArrayList;
import java.util.List;

public class test1 {

    public boolean Find1(int target, int [][] array) {
    //自己的做法
        List<Integer> list = new ArrayList<Integer>();

        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                list.add(array[i][j]);
            }
        }

        if(list.contains(target)){
            return true;
        }
        return false;
    }

    public boolean Find2(int target, int [][] array){
        for(int i=0;i<array.length;i++){
            int lo = 0;
            int hi = array[i].length-1;

            while(lo<=hi){
                int mid = (lo+hi)/2;
                if(array[i][mid]<target){
                    lo=mid+1;
                }else if(array[i][mid]>target){
                    hi=mid-1;
                }else{
                    return true;
                }
            }
        }
        return false;
    }

    public boolean Find3(int [][] array,int target) {
        int row=0;
        int col=array[0].length-1;
        while(row<=array.length-1&&col>=0){
            if(target==array[row][col])
                return true;
            else if(target>array[row][col])
                row++;
            else
                col--;
        }
        return false;

    }

}
