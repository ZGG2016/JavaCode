package jianzhioffer.part3;

public class test4 {
    public static void main(String[] args){

        int[] arr = {364,637,341,406,747,995,234,971,571,219,993,407,416,
                366,315,301,601,650,418,355,460,505,360,965,516,648,727,
                667,465,849,455,181,486,149,588,233,144,174,557,67,746,
                550,474,162,268,142,463,221,882,576,604,739,288,569,
                256,936,275,401,497,82,935,983,583,523,697,478,147,
                795,380,973,958,115,773,870,259,655,446,863,735,784,
                3,671,433,630,425,930,64,266,235,187,284,665,874,80,
                45,848,38,811,267,575};

        System.out.println(InversePairs(arr));

    }


    private static int InversePairs(int[] array) {
        if(array==null || array.length==0) return 0;

        int n = array.length;
        int[] copy = new int[n];
        for(int i=0;i<n;i++){
           copy[i] = array[i];
        }

        int rlt = helper(array,copy,0,n-1)%1000000007;
        return rlt;
    }

    private static int helper(int[] array, int[] copy, int start, int end) {
        if(start==end) return 0;

        int mid = (start+end)/2;
        //���������������Ƚϴ󣬶�ÿ�η��ص�count mod(1000000007)����
        int left = helper(array,copy,start,mid)%1000000007;
        int right = helper(array,copy,mid+1,end)%1000000007;

        int count = 0;
        int i = mid;
        int j = end;
        int k = end;
        while(i>=start && j>=mid+1){
            if(array[i]>array[j]){
                count+=j-mid;
                copy[k--] = array[i--];
                if(count>=1000000007)//��ֵ��������
                {
                    count%=1000000007;
                }
            }else{
                copy[k--] = array[j--];
            }
        }
        for(;i>=start;i--){
            copy[k--] = array[i];
        }
        for(;j>=mid+1;j--){
            copy[k--] = array[j];
        }

        for(int s=start;s<=end;s++)
        {
            array[s] = copy[s];
        }
        return left+right+count;
    }
}
