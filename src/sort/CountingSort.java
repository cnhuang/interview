package sort;

import utility.UtilMgr;

public class CountingSort {

	public static void Sort (int[] arr, int min, int max) 
	{
		System.out.print("\n\nQuick Sort: Initial Array: " );
		UtilMgr.Print(arr);
		
		int range = max-min+1;
		int[] c = new int[range];
		for(int i : arr)
			c[i-min]++;
		
		int index = 0;
		for(int i = 0 ; i < range ; i++)
			for(int j = 0 ; j < c[i]; j++)
				arr[index++] = i+min;
		
		System.out.print("\n\nQuick Sort: Result Array: " );
		UtilMgr.Print(arr);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CountingSort.Sort(new int[]{5,12,6,86,343,5,24,35,7,9},5,343);
		CountingSort.Sort(new int[]{5,5,5,5,5,5,5,5,5,5,5,5},5,5);
		CountingSort.Sort(new int[]{10,9,8,7,6,5,4,3,2,1},1,10);
		CountingSort.Sort(new int[]{10},10,10);
		CountingSort.Sort(new int[]{10,9},9,10);
		CountingSort.Sort(new int[]{},0,0);


	}

}
