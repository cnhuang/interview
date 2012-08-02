package sort;

import utility.UtilMgr;

public class RadixSort {

	public static void Sort(int[] arr) {
		
		if(arr.length < 2)
			return;
		
		System.out.print("\n\nRadix Sort: Initial Array: " );
		UtilMgr.Print(arr);
		
		int f = 10;
		int count = 0;
		
		do
		{			
			count = 0;
			for(int i = arr.length-2 ; i >= 0 ; i--)
			{
				if( arr[i] % f > 0)
					count ++;
				
				for(int j = i; j < arr.length-1 ; j++)
				{	
					if(arr[j] % f > arr[j+1] % f)
					{
						int tmp = arr[j+1];
						arr[j+1] = arr[j];
						arr[j] = tmp;
					}
					else
						break;
				}
			}
			
			f*=10;
			System.out.println();
			UtilMgr.Print(arr);
			System.out.println();
		}while(count != 0);
		
		System.out.print("\n\nRadix Sort: Result Array: " );
		UtilMgr.Print(arr);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RadixSort.Sort(new int[]{5,12,6,86,343,5,24,35,7,9});
		RadixSort.Sort(new int[]{5,5,5,5,5,5,5,5,5,5,5,5});
		RadixSort.Sort(new int[]{10,9,8,7,6,5,4,3,2,1});
		RadixSort.Sort(new int[]{10,Integer.MAX_VALUE});
		RadixSort.Sort(new int[]{10,9});
		RadixSort.Sort(new int[]{});


	}

}
