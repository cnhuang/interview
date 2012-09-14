package question.amazon;

import java.util.Random;

public class MaxDiff
{

	//http://www.careercup.com/question?id=12705676
	//one unsorted array is given.Find out the index i and j ,
	//j> i for which a[j] - a[i] is maximum.perform in linear time complexity

	public static void main(String[] args)
	{
		Random rand = new Random(System.currentTimeMillis());
		int size = 10;
		int[] arr = new int[size];
		for(int i = 0 ; i < size ; i++)
		{
			arr[i] = rand.nextInt(20);
			System.out.print(arr[i]+",");
		}
		System.out.println();
		Find(new int[]{5,4,3,2,1,9});
	}
	
	
	public static void Find(int[] arr)
	{
		if(arr == null || arr.length < 2)
		{
			return;
		}
		
		int tmpN = 0;
		int n1 = -1;
		int n2 = -1;
		
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 1 ; i < arr.length ; i++)
		{
			
			if(max < arr[i] - arr[tmpN])
			{
				max = arr[i] - arr[tmpN];
				n2 = i;
				n1 = tmpN;
			}
			
			if(arr[i] < arr[tmpN])
			{
				tmpN = i;				
			}
		}
		
		System.out.println("N1 = "+n1+"("+arr[n1]+"), N2 = "+n2+"("+arr[n2]+"), Max = "+max);
		
	}

}
