package JianZhiOffer.part1;

public class test12 {

    public double Power1(double base, int exponent) {
        double rlt = 1.0;
        int tmp = Math.abs(exponent);
        while(tmp!=0){
            rlt *=base;
            tmp--;
        }
        return exponent<0?1/rlt:rlt;
    }

    public double Power2(double base, int exponent) {
        if(eq(base,0) && exponent<0){
            return 0.0;  //分母为0，分子为负
        }

        int realexp = exponent;
        if(exponent<0) realexp = -exponent;
        double ans = helper(base,realexp);
        if(exponent<0) return 1/ans;
        return ans;
    }
    //二分快速幂 https://blog.csdn.net/tcm_zhangpeng/article/details/49737509
    private double helper(double a,int b){
        if(b==0){return 1.0;}
        else if(b==1) {return a;}

        double c = helper(a,b/2);
        c*=c;
        if((b&1)==1){c*=a;}
        return c;
    }

    private boolean eq(double a,double b){ //浮点数比较相等
        if((a-b)>-0.000001 && (a-b)<0.000001){
            return true;
        }
        return false;
    }

}
