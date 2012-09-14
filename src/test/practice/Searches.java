package test.practice;



import java.util.Arrays;

public class Searches
{
	public static void main(String[] args)
	{
		int[] data = Sorts.GetTestData();
		Arrays.sort(data);
		System.out.println("Original:" + Arrays.toString(data));

		for (int i : data)
		{
			int r = BinarySearch(data, i, 0, data.length - 1);
			int r2 = BinarySearch2(data,i);
			System.out.println(String.format("%d is found at %d and %d", i, r, r2));
		}

		int r = BinarySearch(data, 101, 0, data.length - 1);
		int r2 = BinarySearch2(data,101);
		System.out.println(String.format("%d is found at %d and %d", 101, r, r2));
	}

	public static int BinarySearch(int[] data, int target, int s, int e)
	{
		if (e < s)
			return -1;

		int m = (s + e) / 2;

		if (data[m] == target)
			return m;
		else if (data[m] > target)
			return BinarySearch(data, target, s, m - 1);
		else
			return BinarySearch(data, target, m + 1, e);
	}
	
	public static int BinarySearch2(int[] data, int target)
	{
		int s = 0, e = data.length-1;
		
		while(s <= e)
		{
			int m = (s+e)/2;
			if (data[m] == target)
				return m;
			else if (data[m] > target)
				e = m-1;
			else
				s = m+1;
		}
		
		return -1;
	}

}
