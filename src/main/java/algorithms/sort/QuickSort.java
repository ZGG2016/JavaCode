package algorithms.sort;
/*
 * 快速排序
 * */

public class QuickSort {
	public static void main(String[] args) {
		//int[] arr={ 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
        int[] arr={ 2, 3 , 4 , 5};
        quickSort(arr);
        for (int value : arr) {
            System.out.println(value);
        }
	}

    public static void quickSort(int[] arr){
        if(arr.length == 0) return;
        sort(arr , 0, arr.length-1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
	}
	private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {
            while (a[++i]< v){
                if (i == hi) break;  // 遍历到 hi 位置，仍比 v 小，就得退出循环，否则数组越界。
            }
            while (v<a[--j]){
                if (j == lo) break;
            }
            if (i >= j){   //  当两个指针i、j相遇交换后，i 大于 j。等于是两指针在同一位置
                break;
            }
            exch(a, i, j);

        }
        exch(a, lo, j); //当两个指针相遇交换后，再交换 A 和左子数组的最右侧元素交换。
        return j;
    }

    private static void exch(int[] arr, int i, int j) {
        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;

    }

//========================================================================
    // 三向切分的快速排序
    public static void quickSort3Way(int[] arr) {
        if(arr.length == 0) return;
	    quickSort3Way(arr, 0, arr.length - 1);
    }
    private static void quickSort3Way(int[] arr, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        int v = arr[lo];
        int i = lo;
        while (i <= gt) {
            int cmp = arr[i] - v;
            if      (cmp < 0) exch(arr, lt++, i++);
            else if (cmp > 0) exch(arr, i, gt--);
            else              i++;
        }

        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        quickSort3Way(arr, lo, lt-1);
        quickSort3Way(arr, gt+1, hi);
    }
}
