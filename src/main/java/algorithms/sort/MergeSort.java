//package algorithms.sort;
//
//
//import edu.princeton.cs.algs4.StdOut;
//
//public class MergeSort {
///*
//*  �鲢����
// * ���:�Ѵ��������з�Ϊ���ɸ������У�ÿ��������������ġ�Ȼ���ٰ����������кϲ�Ϊ�����������С�
// *
// * �鲢������Ҫ���Ƿֽ⣬�͹鲢���������֣��ֽ���Ҫɨ�����е�Ԫ�أ�����ʱ�临�Ӷ�ΪO��n����
// * �鲢�����У������鲢����ʵ�����������������Ϊlogn��ÿһ�㶼Ҫ���������Ƚϣ�Ҳ����n�Σ�
// * ����ʱ�临�Ӷ�ΪO��nlogn�����鲢����������Ҫ��������õ�Ԫ�أ����Կռ临�Ӷ�ΪO��n����
// *
// * �ȶ�����ʽ
// *
// * �ȶ��ԣ�
// * �ٶ��ڴ�����ļ�¼�����У����ڶ��������ͬ�Ĺؼ��ֵļ�¼��������������Щ��¼����Դ��򱣳ֲ��䣬
// * ����ԭ�����У�ri=rj����ri��rj֮ǰ�����������������У�ri����rj֮ǰ��������������㷨���ȶ��ģ�
// * �����Ϊ���ȶ��ġ�
// * */
//	public static void main(String[] args) {
//		int[] arr = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
//		sort(arr);
//        show(arr);
//	}
//
//    /*
//     * �Զ����£������������������������ٽ�����������������ν��У����ϲ�
//     *
//     * */
//
//    public static void sort(int[] arr){
//        int[] aux = new int[arr.length];
//        sort(arr,aux,0,arr.length);
//    }
//
//    public static void sort(int[] arr, int[] aux,int lo, int hi) {
//
//        if (hi <= lo) return;  //ֹͣ����
//        int mid = lo + (hi - lo) / 2;
//        sort(arr, aux,lo, mid);
//        sort(arr, aux,mid + 1, hi);
//        merge(arr, aux,lo, mid, hi);
//    }
//
//	public static void merge(int[] a, int[] aux, int lo, int mid, int hi){
//
//
//		for (int k = lo; k <= hi; k++) {
//            aux[k] = a[k];
//        }
//
//        int i = lo, j = mid+1;
//        for (int k = lo; k <= hi; k++) {  //ע�ⷶΧ
//            if      (i > mid)              a[k] = aux[j++];  //��߲��ֱ����꣬���ұ߲��ֵ�ֵ�ӵ�aux
//            else if (j > hi)               a[k] = aux[i++];  //�ұ߲��ֱ����꣬����߲��ֵ�ֵ�ӵ�aux
//            else if (aux[j]<aux[i])        a[k] = aux[j++];
//            else                           a[k] = aux[i++];
//        }
//	}
//
//	public static void show(int[] a) {
//        for (int anA : a) {
//            StdOut.println(anA);
//        }
//    }
//
//
//}
//
////�������
////    public static void merge(int[] nums, int low, int mid, int high) {
////        int[] temp = new int[high - low + 1];
////
////        int i = low;// ��ָ��
////        int j = mid + 1;// ��ָ��
////        int k = 0;
////
////        // �ѽ�С�������Ƶ���������
////        while (i <= mid && j <= high) {
////            if (nums[i] < nums[j]) {
////                temp[k++] = nums[i++];
////            } else {
////                temp[k++] = nums[j++];
////            }
////        }
////
////        // �����ʣ�������������
////        while (i <= mid) {
////            temp[k++] = nums[i++];
////        }
////
////        // ���ұ߱�ʣ�������������
////        while (j <= high) {
////            temp[k++] = nums[j++];
////        }
////
////        // ���������е�������nums����
////        for (int k2 = 0; k2 < temp.length; k2++) {
////            nums[k2 + low] = temp[k2];
////        }