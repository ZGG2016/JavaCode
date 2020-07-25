//package algorithms.sort;
//
//import edu.princeton.cs.algs4.StdOut;
//
///**
// * 自底向上的归并排序：
// *       把开始未排序的，每个元素视为已排序序列，再将这些长度为1的序列合并成长度为2的序列，
// *       依次往下进行------>1-2-4-8-16
// *
// *
// * */
//
//public class MergeBU {
//
//	public static void main(String[] args) {
//		int[] a = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
//        MergeBU.sort(a);
//        show(a);
//    }
//	public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
//
//        for (int k = lo; k <= hi; k++) {
//            aux[k] = a[k];
//        }
//
//        int i = lo, j = mid+1;
//        for (int k = lo; k <= hi; k++) {
//            if      (i > mid)              a[k] = aux[j++];    //左边用完，取右边，注意i,j，mid是索引
//            else if (j > hi)               a[k] = aux[i++];   //右边用完，取左边
//            else if(aux[j]<aux[i])         a[k] = aux[j++];     //当左边元素大于右边元素时，取右边
//            else                           a[k] = aux[i++];   //当右边元素大于左边元素时，取左边
//        }
//
//    }
//	public static void sort(int[] a) {
//        int n = a.length;
//        int[] aux = new int[n];
//        for (int len = 1; len < n; len *= 2) {   //合并长度为len的序列。len子序列长度 1-2-4-8-16...
//            //一次归并排序都是使用2组数据进行排序,所以每次递增2组数据的偏移量
//            //取到倒数第二元素
//            for (int lo = 0; lo < n-len; lo += len+len) {
//                int mid  = lo+len-1;
//                int hi = Math.min(lo+len+len-1, n-1);  //剩余的元素进入下一次迭代
//                merge(a, aux, lo, mid, hi);
//            }
//        }
//     }
//
//
//    public static void show(int[] a) {
//        for (int i = 0; i < a.length; i++) {
//             StdOut.println(a[i]);
//        }
//    }
//
//}
