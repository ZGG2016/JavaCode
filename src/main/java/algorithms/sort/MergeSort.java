package algorithms.sort;

public class MergeSort {
/*
*  �鲢����
 * ���:�Ѵ��������з�Ϊ���ɸ������У�ÿ��������������ġ�Ȼ���ٰ����������кϲ�Ϊ�����������С�
 *
 * �鲢������Ҫ���Ƿֽ⣬�͹鲢���������֣��ֽ���Ҫɨ�����е�Ԫ�أ�����ʱ�临�Ӷ�ΪO��n����
 * �鲢�����У������鲢����ʵ�����������������Ϊlogn��ÿһ�㶼Ҫ���������Ƚϣ�Ҳ����n�Σ�
 * ����ʱ�临�Ӷ�ΪO��nlogn�����鲢����������Ҫ��������õ�Ԫ�أ����Կռ临�Ӷ�ΪO��n����
 *
 *
 * �Զ����µĹ鲢����
 * */
	public static void main(String[] args) {
		int[] arr = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
        mergeSort(arr);
        for (int s : arr) {
            System.out.println(s);
        }
	}

    public static void mergeSort(int[] arr){
	    if(arr.length == 0) return;

        int[] aux = new int[arr.length];
        sort(arr,aux,0,arr.length-1);
    }

    private static void sort(int[] arr, int[] aux, int lo, int hi) {

        if (hi <= lo) return;  //ֹͣ����

        int mid = lo + (hi - lo) / 2;
        sort(arr, aux,lo, mid);  // ע�⣺lo,mid
        sort(arr, aux,mid + 1, hi);
        merge(arr, aux,lo, mid, hi);  // ע�⣺mid
    }

    private static void merge(int[] arr, int[] aux, int lo, int mid, int hi){


		for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k];
        }

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {  //ע�ⷶΧ
            if      (i > mid)              arr[k] = aux[j++];  //��߲��ֱ����꣬���ұ߲��ֵ�ֵ�ӵ�aux
            else if (j > hi)               arr[k] = aux[i++];  //�ұ߲��ֱ����꣬����߲��ֵ�ֵ�ӵ�aux
            else if (aux[j]<aux[i])        arr[k] = aux[j++];  //�ұߵ�ǰԪ��С����ߵ�ǰԪ�أ�ȡ�ұ�
            else                           arr[k] = aux[i++];  //�ұߵ�ǰԪ�ش��ڵ�����ߵ�ǰԪ�أ�ȡ���
        }
	}
}

//�������
//    public static void merge(int[] nums, int low, int mid, int high) {
//        int[] temp = new int[high - low + 1];
//
//        int i = low;// ��ָ��
//        int j = mid + 1;// ��ָ��
//        int k = 0;
//
//        // �ѽ�С�������Ƶ���������
//        while (i <= mid && j <= high) {
//            if (nums[i] < nums[j]) {
//                temp[k++] = nums[i++];
//            } else {
//                temp[k++] = nums[j++];
//            }
//        }
//
//        // �����ʣ�������������
//        while (i <= mid) {
//            temp[k++] = nums[i++];
//        }
//
//        // ���ұ߱�ʣ�������������
//        while (j <= high) {
//            temp[k++] = nums[j++];
//        }
//
//        // ���������е�������nums����
//        for (int k2 = 0; k2 < temp.length; k2++) {
//            nums[k2 + low] = temp[k2];
//        }