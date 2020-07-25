///******************************************************************************
// *  Compilation:  javac Heap.java
// *  Execution:    java Heap < input.txt
// *  Dependencies: StdOut.java StdIn.java
// *  Data files:   http://algs4.cs.princeton.edu/24pq/tiny.txt
// *                http://algs4.cs.princeton.edu/24pq/words3.txt
// *
// *  Sorts a sequence of strings from standard input using heapsort.
// *
// *  % more tiny.txt
// *  S O R T E X A M P L E
// *
// *  % java Heap < tiny.txt
// *  A E E L M O P R S T X                 [ one string per line ]
// *
// *  % more words3.txt
// *  bed bug dad yes zoo ... all bad yet
// *
// *  % java Heap < words3.txt
// *  all bad bed bug dad ... yes yet zoo   [ one string per line ]
// *
// ******************************************************************************/
//
//package algorithms.sort;
//
//import edu.princeton.cs.algs4.StdOut;
//
///**
// *  The {@code Heap} class provides a static methods for heapsorting
// *  an array.
// *  <p>
// *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/24pq">Section 2.4</a> of
// *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
// *
// *  @author Robert Sedgewick
// *  @author Kevin Wayne
// *
// *  用长度为N+1的数组pq[]表示一个大小为N的堆，堆元素存放在pq[1]至pq[N]
// *
// *
// * 堆排序：
// * 构造堆，将原始数组重新组织进一个堆中；使用sink()方法
// * 下沉排序，重复删除最大元素，放入堆缩小后数组中空出的位置
// * 从堆中按递减顺序取出所有元素并得到排序结果
// *
// * 最坏，最好，平均时间复杂度均为O(nlogn)，它也是不稳定排序。
// * 空间复杂度：O(1)
// *
// */
//public class Heap {
//
//    // This class should not be instantiated.
//    private Heap() { }
//
//    /**
//     * Rearranges the array in ascending order, using the natural order.
//     * @param pq the array to be sorted
//     */
//    public static void sort(Comparable[] pq) {
//        int n = pq.length;
//        for (int k = n/2; k >= 1; k--)
//            sink(pq, k, n);
//        while (n > 1) {
//            exch(pq, 1, n--);
//            sink(pq, 1, n);
//        }
//    }
//
//   /***************************************************************************
//    * Helper functions to restore the heap invariant.
//    ***************************************************************************/
//
//    private static void sink(Comparable[] pq, int k, int n) {
//        while (2*k <= n) {
//            int j = 2*k;
//            if (j < n && less(pq, j, j+1)) j++;//判断两个子结点哪个大，用较大的来交换它们的父结点
//            if (!less(pq, k, j)) break;
//            exch(pq, k, j);
//            k = j;
//        }
//    }
//
//    public void swim(Comparable[] pq,int k){
//        while(k>1 && less(pq,k/2,k)){
//            exch(pq,k/2,k);
//            k=k/2;
//        }
//    }
//
//   /***************************************************************************
//    * Helper functions for comparisons and swaps.
//    * Indices are "off-by-one" to support 1-based indexing.
//    ***************************************************************************/
//    private static boolean less(Comparable[] pq, int i, int j) {
//        return pq[i-1].compareTo(pq[j-1]) < 0;
//    }
//
//    private static void exch(Object[] pq, int i, int j) {
//        Object swap = pq[i-1];  //数组从0开始
//        pq[i-1] = pq[j-1];
//        pq[j-1] = swap;
//    }
//
//    // print array to standard output
//    private static void show(Comparable[] a) {
//        for (int i = 0; i < a.length; i++) {
//            StdOut.println(a[i]);
//        }
//    }
//
//    /**
//     * Reads in a sequence of strings from standard input; heapsorts them;
//     * and prints them to standard output in ascending order.
//     *
//     * @param args the command-line arguments
//     */
//    public static void main(String[] args) {
//       // String[] a = StdIn.readAllStrings();
//    	String[] a={"S","O","R","T","E","X","A","M","P","L","E"};
//        Heap.sort(a);
//        show(a);
//    }
//}
//
//
