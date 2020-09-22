package jianzhioffer.part3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class test9 {

    public void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        ArrayList<Integer>list=new ArrayList<Integer>();
        for(int i=0;i<array.length;i++)
        {
            if(!list.contains(array[i]))
                list.add(array[i]);
            else
                list.remove(new Integer(array[i]));
        }
        if(list.size()>1)
        {
            num1[0]=list.get(0);
            num2[0]=list.get(1);
        }
    }

    public void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
        if (array == null && array.length ==0) {
            num1[0] = num2[0] = 0;
            return;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], 2);
            } else {
                map.put(array[i], 1);
            }
        }
        num1[0] = 0;
        for (Map.Entry entry : map.entrySet()) {
            if ((Integer) entry.getValue() == 1) {
                if (num1[0] == 0) {
                    num1[0] = (Integer) entry.getKey();
                } else {
                    num2[0] = (Integer) entry.getKey();
                }
            }
        }
//        int i=0;
//        for(Integer key:hm.keySet()){
//            if(hm.get(key)==1){
//                i++;
//                if(i==1){
//                    num1[0] = key;
//                }else if(i==2){
//                    num2[0] = key;
//                }
//            }
//        }
    }
}
