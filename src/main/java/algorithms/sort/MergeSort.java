//package algorithms.sort;
//
//
//import edu.princeton.cs.algs4.StdOut;
//
//public class MergeSort {
///*
//*  归并排序
// * 简介:把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
// *
// * 归并排序主要就是分解，和归并排序两部分，分解需要扫描所有的元素，所以时间复杂度为O（n）。
// * 归并过程中，两两归并，其实就是满二叉树，深度为logn，每一层都要进行两两比较，也就是n次，
// * 所以时间复杂度为O（nlogn）。归并过程中是需要保存排序好的元素，所以空间复杂度为O（n）。
// *
// * 稳定排序方式
// *
// * 稳定性：
// * 假定在待排序的记录序列中，存在多个具有相同的关键字的记录，若经过排序，这些记录的相对次序保持不变，
// * 即在原序列中，ri=rj，且ri在rj之前，而在排序后的序列中，ri仍在rj之前，则称这种排序算法是稳定的；
// * 否则称为不稳定的。
// * */
//	public static void main(String[] args) {
//		int[] arr = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
//		sort(arr);
//        show(arr);
//	}
//
//    /*
//     * 自顶向下：将数组拆成两个子数组排序，再将这两个子数组拆，依次进行，最后合并
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
//        if (hi <= lo) return;  //停止条件
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
//        for (int k = lo; k <= hi; k++) {  //注意范围
//            if      (i > mid)              a[k] = aux[j++];  //左边部分遍历完，将右边部分的值加到aux
//            else if (j > hi)               a[k] = aux[i++];  //右边部分遍历完，将左边部分的值加到aux
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
////帮助理解
////    public static void merge(int[] nums, int low, int mid, int high) {
////        int[] temp = new int[high - low + 1];
////
////        int i = low;// 左指针
////        int j = mid + 1;// 右指针
////        int k = 0;
////
////        // 把较小的数先移到新数组中
////        while (i <= mid && j <= high) {
////            if (nums[i] < nums[j]) {
////                temp[k++] = nums[i++];
////            } else {
////                temp[k++] = nums[j++];
////            }
////        }
////
////        // 把左边剩余的数移入数组
////        while (i <= mid) {
////            temp[k++] = nums[i++];
////        }
////
////        // 把右边边剩余的数移入数组
////        while (j <= high) {
////            temp[k++] = nums[j++];
////        }
////
////        // 把新数组中的数覆盖nums数组
////        for (int k2 = 0; k2 < temp.length; k2++) {
////            nums[k2 + low] = temp[k2];
////        }