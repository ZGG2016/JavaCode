package jianzhioffer;

public class test1 {

    private int[] multiply(int[] A) {
        //B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1] ==》去掉了A[]
        //理解成对角线元素初始为1的n*n矩形，求对角线元素
        //先算左边的乘积，再乘以右边的乘积
        int len = A.length;
        int[] B = new int[len];
        //算左边的乘积，放到数组中
        B[0] = 1;//最左上角第一个元素初始为1（放左边数的乘积）
        //b[3] = a[2]*a[1]*a[0] = a[2] * b[2]
        for(int i= 1; i<len ; i++){
            B[i] = A[i-1] * B[i-1];
        }

        //算右边的乘积，再和左边相乘
        int tmp = 1;//放右边数的乘积
        for(int j=len-2; j>=0 ; j--){
            tmp *= A[j+1];
            B[j] *= tmp;
        }
        return B;
    }
}
