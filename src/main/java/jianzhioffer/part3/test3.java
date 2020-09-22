package jianzhioffer.part3;

import java.util.HashMap;

public class test3 {
    public static void main(String[] args){
        test3 t = new test3();
        System.out.println(t.FirstNotRepeatingChar("google"));
    }

    public int FirstNotRepeatingChar(String str) {
        if(str==null || str.equals("")) return -1;

        HashMap<Character,Integer> hm = new HashMap<>();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!hm.containsKey(ch)){
                hm.put(ch,1);
            }else{
                hm.put(ch,hm.get(ch)+1);
            }
        }

        for(int i=0;i<str.length();i++){  //输出的是在str中的位置
            if(hm.get(str.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
