package JianZhiOffer.part2;

public class test1 {

    //判断序列能不能构建BST
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0) return false;
        if(sequence.length==1) return true;
        return hepler(sequence,0,sequence.length-1);
    }
    private boolean hepler(int[] arr,int start,int end){
        // 1、4、3、5
        if(start>=end) return true;
        int root = arr[end];
        int i=0;
        while(arr[i]<root){
            i++;
        }

        for(int j=i;j<end;j++){
            if(arr[j]<root) return false;
        }

        return hepler(arr,start,i-1) && hepler(arr,i,end-1);
    }
}
