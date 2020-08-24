package JianZhiOffer.part1;

public class test10 {
    /*
    * 2*1的小矩形横着放，f(n-2)
    *           竖着放f(n-1)
    * */
    public int RectCover(int target) {
        if(target<=0) return 0;
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
