package test.practice;

import java.util.Arrays;
import java.util.Random;

public class Sorts
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

	public static void BubbleSort(int[] input)
	{
		input = Copy(input);
		for (int i = 1; i < input.length; i++)
			for (int j = i; j > 0; j--)
			{
				if (input[j] < input[j - 1])
				{
					int tmp = input[j - 1];
					input[j - 1] = input[j];
					input[j] = tmp;
				}
			}

		System.out.println("BubbleSort:" + Arrays.toString(input));
	}

	public static int[] MergeSort(int[] input, int s, int e)
	{
		if (e == s)
			return new int[] { input[s] };
		else if (e < s)
			return new int[0];
		else
		{
			int m = (s + e) / 2;
			return Merge(MergeSort(input, s, m), MergeSort(input, m + 1, e));
		}
	}

	public static int[] Merge(int[] arr1, int[] arr2)
	{
		int[] data = new int[arr1.length + arr2.length];
		int index1 = 0, index2 = 0, index = 0;

		while (true)
		{
			if (index1 == arr1.length)
			{
				for (; index2 < arr2.length; index2++)
					data[index++] = arr2[index2];
				break;
			}

			if (index2 == arr2.length)
			{
				for (; index1 < arr1.length; index1++)
					data[index++] = arr1[index1];
				break;
			}

			if (arr1[index1] <= arr2[index2])
			{
				data[index++] = arr1[index1++];
			} else
			{
				data[index++] = arr2[index2++];
			}
		}

		return data;
	}

	public static void QuickSort(int[] input, int s, int e)
	{
		if (e <= s)
			return;

		int pivot = input[(s + e) / 2];
		int i = s;
		int j = e;

		while (i <= j)
		{
			while (input[i] < pivot)
				i++;

			while (input[j] > pivot)
				j--;

			if (i <= j)
			{
				int tmp = input[j];
				input[j] = input[i];
				input[i] = tmp;
				i++;
				j--;
			}
		}

		QuickSort(input, s, j);
		QuickSort(input, i, e);

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
