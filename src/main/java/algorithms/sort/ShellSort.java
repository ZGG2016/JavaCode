package algorithms.sort;
/*
 * 希尔排序：h-someExample.sort
 *   1,一种基于插入排序的排序算法： 
 *       Big Increments--->Samll Subarray
 *       Small Increments--->nearly in order
 *   2,g-有序数组经过h-排序后仍然是g-有序数组
 *   3，使用哪种增量序列？
 *          3X+1增量序列  1,4,13,40,121.。。。
 *   4，首先找到小于待排序数组的长度最大的增量值h，
 *      然后依照递减的增量值进行排序,如此反复进行。
 * 	 5、在插入排序的代码中将移动元素的距离由1改为h
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
		while(h<n/3){   //找到小于待排序数组的长度最大的增量值h，
			h=h*3+1;
		}
		while(h>=1){ //在不同粒度上比，取不同的增量
			for(int i=h;i<n;i++){
			    //for(int j=i;j-h>=0 && arr[j]<arr[j-h];j-=h){
				for(int j=i;j>=h && arr[j]<arr[j-h];j-=h){  //插入排序,原来是1，现在只是宽度成了h
					exch(arr,j,j-h);
				}
			}
			h /= 3;   //设置新的增量值
			
		}
	}

    public static void exch(int[] arr,int i,int j){
        int t=arr[j];
        arr[j]=arr[i];
        arr[i]=t;
    }

}
