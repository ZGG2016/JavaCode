package JianZhiOffer.part1;

public class test6 {
    /*
    * �����Ŀ��
    *       �������ҳ��������СԪ��
    *       Ȼ�� ��Ŀ��ǰ�����ǽ������������
    *
    * */
    public int minNumberInRotateArray1(int [] array) {
        if(array.length==0) return 0;

        for(int i=0;i<array.length-1;i++){
            if(array[i]>array[i+1]){
                return array[i+1];
            }
        }
        return array[0];
    }
    public int minNumberInRotateArray2(int [] array) {
        if(array.length==0) return 0;

        int lo=0;
        int hi=array.length-1;
        int mid=0;
        while(array[lo]>=array[hi]){ //ʼ����������
            if(hi-lo==1){
                mid=hi;
                break;
            }
            mid = lo+(hi-lo)/2;
            if (array[mid] >= array[lo]) {
                lo = mid;
            }
            if (array[mid] <= array[hi]) {
                hi = mid;
            }
        }
        return array[mid];
    }
}
