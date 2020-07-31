package algorithms.sort;

/**
 * �Ե����ϵĹ鲢����
 *       �ѿ�ʼδ����ģ�ÿ��Ԫ����Ϊ���������У��ٽ���Щ����Ϊ1�����кϲ��ɳ���Ϊ2�����У�
 *       �������½���------>1-2-4-8-16
 *
 * */

public class MergeBU {

	public static void main(String[] args) {
		int[] arr = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
        mergeSort(arr);
        for (int s : arr) {
            System.out.println(s);
        }
    }

    public static void mergeSort(int[] arr){
        if(arr.length == 0) return;

        sort(arr);
    }

    private static void sort(int[] a) {
        int n = a.length;
        int[] aux = new int[n];
        for (int len = 1; len < n; len *= 2) {   //�ϲ�����Ϊlen�����С�len�����г��� 1-2-4-8-16...
            //һ�ι鲢������ʹ��2�����ݽ�������,����ÿ�ε���2�����ݵ�ƫ����
            //ȡ�������ڶ�Ԫ��
            for (int lo = 0; lo < n-len; lo += len+len) {
                int mid  = lo+len-1;
                int hi = Math.min(lo+len+len-1, n-1);  //ʣ���Ԫ�ؽ�����һ�ε���
                merge(a, aux, lo, mid, hi);
            }
        }
    }

    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];    //������꣬ȡ�ұߣ�ע��i,j��mid������
            else if (j > hi)               a[k] = aux[i++];   //�ұ����꣬ȡ���
            else if(aux[j]<aux[i])         a[k] = aux[j++];     //�����Ԫ�ش����ұ�Ԫ��ʱ��ȡ�ұ�
            else                           a[k] = aux[i++];   //���ұ�Ԫ�ش������Ԫ��ʱ��ȡ���
        }

    }

}
