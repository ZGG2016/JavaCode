package algorithms.sort;
/* ѡ������ :
 *     �������飺int[] arr={����n������}����1�������ڴ���������arr[1]~arr[n]��
 *     ѡ����С�����ݣ�������arrr[1]��������2�ˣ��ڴ���������arr[2]~arr[n]��ѡ��
 *     ��С�����ݣ�������r[2]�������Դ����ƣ���i���ڴ���������arr[i]~arr[n]��ѡ��
 *     ��С�����ݣ�������r[i]������ֱ��ȫ��������ɡ�
 *
 *  ʱ�临�Ӷ�O(n*2),�ռ临�Ӷ�O(1)
 *
 *  ���ȶ�
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
//					min=j;   //����Ŀǰ�ҵ�����Сֵ���ڵ�λ��
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
