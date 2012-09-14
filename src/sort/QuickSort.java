package sort;

import java.util.*;
import utility.*;

//best nlogn, worst n^2

public class QuickSort {
	
	static Random _rand = new Random(System.currentTimeMillis());

	public static void Sort(int[] arr) {
		System.out.print("\n\nQuick Sort: Initial Array: " );
		UtilMgr.Print(arr);

		InternalSort(arr, 0, arr.length - 1);

		System.out.print("\nQuick Sort: Result Array: " );
		UtilMgr.Print(arr);
	}

	private static void InternalSort(int[] arr, int s, int e)
	{
		int length = e-s+1;
		
		if(length <= 1  )
			return;
		
		int pivotIndex = (s+e)/2;
		int pivot = arr[pivotIndex];
		int i = s;
		int j = e;
		
		while(i <= j)
		{
			while(arr[i] < pivot )
				i++;

			while(arr[j] > pivot )
				j--;
			
			if(j >= i)
			{
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}		
		InternalSort(arr,s,j);
		InternalSort(arr,i,e);
		
	}

	public static void main(String[] args)
	{
		QuickSort.Sort(new int[]{ 4, 12, 5, 6, 1, 34, 3, 2 });
		QuickSort.Sort(new int[]{5,12,6,86,343,5,24,35,7,9});
		QuickSort.Sort(new int[]{5,5,5,5,5,5,5,5,5,5,5,5});
		QuickSort.Sort(new int[]{10,9,8,7,6,5,4,3,2,1});
		QuickSort.Sort(new int[]{10});
		QuickSort.Sort(new int[]{10,9});
		QuickSort.Sort(new int[]{});
	}

}
