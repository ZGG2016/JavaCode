package JianZhiOffer.part1;

public class test9 {
    /*
    * https://www.nowcoder.com/questionTerminal/22243d016f6b47f2a6928b4313c85387
    * */
    public int JumpFloorII(int target) {
        if(target==1) return 1;
        int a=1,b=2;
        for(int i=2;i<=target;i++){
            b=2*a;
            a=b;
        }
        return b;
    }

    public int JumpFloorII2(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(target - 1);
        }
    }
    public int jumpFloorII3(int number) {
        int a=1;
        return a<<(number-1); //2^(n-1)
    }
}
