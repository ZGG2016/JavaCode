package algorithms;

/*
*
* 递归求阶乘
*
* */
public class Factorial {
    public static void main(String[] agrs){
        System.out.println(f(5));
        System.out.println(f1(5));

    }
    //f(4) = 4*3*2*1 = 4*f(3) = ... = 4*3*2*1*f(0)
    private static int f(int n){
        if(n == 0){
            return 1;    // 递归终止条件
        }

        return n*f(n-1);   //递推公式
    }

    //非递归实现
    private static int f1(int n){
        int rlt = n;
        while(n>1){
            n--;
            rlt *= n;
        }
        return rlt;
    }
}
