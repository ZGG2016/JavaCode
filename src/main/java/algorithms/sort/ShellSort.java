package algorithms.sort;
/*
 * ϣ������h-someExample.sort
 *   1,һ�ֻ��ڲ�������������㷨�� 
 *       Big Increments--->Samll Subarray
 *       Small Increments--->nearly in order
 *   2,g-�������龭��h-�������Ȼ��g-��������
 *   3��ʹ�������������У�
 *          3X+1��������  1,4,13,40,121.������
 *   4�������ҵ�С�ڴ���������ĳ�����������ֵh��
 *      Ȼ�����յݼ�������ֵ��������,��˷������С�
 * 	 5���ڲ�������Ĵ����н��ƶ�Ԫ�صľ�����1��Ϊh
 *
 * */
public class ShellSort {

	public static void main(String[] args) {
		int[] arr={6,2,8,4,1,7};
		sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
	}
	public static void sort(int[] arr){
		int n=arr.length;
		int h=1;
		while(h<n/3){   //�ҵ�С�ڴ���������ĳ�����������ֵh��
			h=h*3+1;
		}
		while(h>=1){ //�ڲ�ͬ�����ϱȣ�ȡ��ͬ������
			for(int i=h;i<n;i++){
			    //for(int j=i;j-h>=0 && arr[j]<arr[j-h];j-=h){
				for(int j=i;j>=h && arr[j]<arr[j-h];j-=h){  //��������,ԭ����1������ֻ�ǿ�ȳ���h
					exch(arr,j,j-h);
				}
			}
			h /= 3;   //�����µ�����ֵ
			
		}
	}

    public static void exch(int[] arr,int i,int j){
        int t=arr[j];
        arr[j]=arr[i];
        arr[i]=t;
    }

}
