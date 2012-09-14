package test.practice.google;

import java.util.Arrays;
import java.util.Random;

public class Sorting
{
	public static void main(String[] args)
	{
		int[] data = GetTestData();
		System.out.println("Original:" + Arrays.toString(data));
		BubbleSort(Copy(data));
		System.out.println("MergeSort:" + Arrays.toString(MergeSort(Copy(data), 0, data.length - 1)));
		int[] input = Copy(data);
		QuickSort(input, 0, data.length - 1);
		System.out.println("QuickSort:" + Arrays.toString(input));
	}

	public static void QuickSort(int[] input, int s, int e)
	{
		if(e <= s)
			return;
		
		int pivot = input[(s+e)/2];
		int i = s;
		int j = e;
		
		while(i <= j)
		{
			while(input[i] < pivot)
				i++;
			
			while(input[j] > pivot)
				j--;
			
			if(i <= j)
			{
				int tmp = input[i];
				input[i] = input[j];
				input[j] = tmp;
				i++;
				j--;
			}
		}
		
		QuickSort(input, s, j);
		QuickSort(input, i, e);
	}
	
	public static void BubbleSort(int[] input)
	{

		for (int i = 1; i < input.length; i++)
		{
			for (int j = i; j >= 1; j--)
			{
				if (input[j] < input[j - 1])
				{
					int tmp = input[j];
					input[j] = input[j - 1];
					input[j - 1] = tmp;
				}
			}
		}

		System.out.println("BubbleSort:" + Arrays.toString(input));
	}

	public static int[] MergeSort(int[] input, int s, int e)
	{
		if (e < s)
			return new int[0];
		else if (e == s)
			return new int[] { input[s] };
		else
		{
			int m = (s + e) / 2;
			return Merge(MergeSort(input, s, m), MergeSort(input, m + 1, e));
		}
	}

	private static int[] Merge(int[] array1, int[] array2)
	{
		int[] result = new int[array1.length + array2.length];

		int index1 = 0, index2 = 0, index = 0;
		
		while(index < result.length)
		{
			if(index1 == array1.length)
			{
				for( ; index2 < array2.length ; )
				{
					result[index++] = array2[index2++];
				}
				continue;
			}
			
			if(index2 == array2.length)
			{
				for( ; index1 < array1.length ; )
				{
					result[index++] = array1[index1++];
				}
				continue;
			}
			
			if(array1[index1] < array2[index2])
			{
				result[index++] = array1[index1++];
			}
			else
				result[index++] = array2[index2++];
		}

		return result;
	}

	public static int[] Copy(int[] input)
	{
		int[] data = new int[input.length];

		for (int i = 0; i < data.length; i++)
			data[i] = input[i];

		return data;
	}

	public static int[] GetTestData()
	{
		Random rand = new Random(System.currentTimeMillis());

		int[] data = new int[20];

		for (int i = 0; i < data.length; i++)
			data[i] = rand.nextInt(100);

		return data;
	}

}
