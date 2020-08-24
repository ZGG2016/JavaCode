package JianZhiOffer.part1;

public class test8 {
    /*
    * 假设跳到第4阶
    *       如果第一下跳一阶，那么下面要跳3阶，接下来的3阶就是之前的3
    *       如果第一下跳二阶，那么下面要跳2阶
    *       （第n阶依赖于前面的n-1阶和n-2阶）
    *       所以是一个斐波那契数列。
    * */
    public int JumpFloor(int target) {

        if(target==1||target==2) return target;
        int a=1,b=2,c=0;
        for(int i=3;i<=target;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
