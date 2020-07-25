package algorithms.sort;
/* 选择排序 :
 *     给定数组：int[] arr={里面n个数据}；第1趟排序，在待排序数据arr[1]~arr[n]中
 *     选出最小的数据，将它与arrr[1]交换；第2趟，在待排序数据arr[2]~arr[n]中选出
 *     最小的数据，将它与r[2]交换；以此类推，第i趟在待排序数据arr[i]~arr[n]中选出
 *     最小的数据，将它与r[i]交换，直到全部排序完成。
 *
 *  时间复杂度O(n*2),空间复杂度O(1)
 *
 *  不稳定
 *
 * */
public class SelectionSort {

	public static void main(String[] args) {
		//int[] arr={6,2,8,4,1,7};
        String[] arr={"X","A","V","L","F"};
		sort(arr);
        for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}

	public static void sort(Comparable[] a){

		int n =a.length;
		for(int i=0;i<n;i++){
			int min=i;
			for(int j=i+1;j<n;j++){
				if(less(a[j],a[min])) min=j;
			}
			exch(a,i,min);
		}
	}

	public static boolean less(Comparable v,Comparable w){
		return v.compareTo(w)<0;
	}
	public static void exch(Object[] a,int i,int j){
		Object tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
//	public static void someExample.sort(int[] arr){
//		for(int i=0;i<arr.length;i++){
//			int min=i;
//			for(int j=i+1;j<arr.length;j++){
//				if(arr[j]<arr[min]){
//					min=j;   //记下目前找到的最小值所在的位置
//				}
//			}
//			if(i!=min){
//				int t=arr[min];
//				arr[min]=arr[i];
//				arr[i]=t;
//			}
//
//		}
//		for(int i=0;i<arr.length;i++){
//			System.out.println(arr[i]);
//		}
//	}

}
