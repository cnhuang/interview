package search;

import java.util.Arrays;
import java.util.Random;

public class BinaryRotationSearch
{	
	public static void main(String[] args)
	{
		int size = 10;
		int[] arr = GetTestArray(size);
		for(int i : arr)
			System.out.println("Find "+i+"->"+Find(i,arr,0,size-1));
		
		System.out.println("Find 1000 ->"+Find(1000,arr,0,size-1));
		System.out.println("Find 0 ->"+Find(0,arr,0,size-1));		
	}
	
	public static int Find(int i, int arr[], int s, int e)
	{
		if(e < s)
			return -1;
		
		int mid = (e+s)/2;
		//System.out.println("Start "+s+" End "+e+" Mid "+mid);
		if(arr[mid] == i)
			return mid;
		else
		{
			//turning point on left
			if(arr[mid] < arr[s])
			{
				//use the continuous part to make decision 
				if( i <= arr[e] && i > arr[mid])
					return Find(i,arr, mid+1,e);
				else
					return Find(i,arr,s,mid-1);
			}			
			//turning point MIGHT be on right
			else 
			{
				//use the continuous part to make decision
				if(i >= arr[s] && i < arr[mid])
					return Find(i,arr,s,mid-1);
				else
					return Find(i,arr,mid+1,e);
			}
		}
	}
	
	public static int[] GetTestArray(int size)
	{
		Random rand = new Random(System.currentTimeMillis());
		
		int[] arr = new int[size];
		
		for(int i = 0 ; i < size ; i++)
			arr[i] = rand.nextInt(1000);
		
		Arrays.sort(arr);
		
		int rotation = rand.nextInt(size);
				
		int[] arr2 = new int[size];
		
		for(int i = 0 ; i < size ; i++)
		{
			arr2[ (i+rotation)%size] = arr[i];
		}
		
		for(int i : arr2)
			System.out.print(i+",");
		System.out.println();
		
		return arr2;
	}

}
