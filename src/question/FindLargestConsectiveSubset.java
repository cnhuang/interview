package question;

import java.util.Arrays;

import org.junit.Test;

public class FindLargestConsectiveSubset
{

	/**
	 * http://www.careercup.com/question?id=11070934 Given an int array which
	 * might contain duplicates, find the largest subset of it which form a
	 * sequence. Eg. {1,6,10,4,7,9,5} then ans is 4,5,6,7
	 */

	@Test
	public void FindTest()
	{
		Find(new int[] { 1, 6, 10, 4, 2, 9, 11, 10, 5 });
		Find2(new int[] { 1, 6, 10, 4, 2, 9, 11, 10, 5 });
	}

	// O(N) space
	public void Find(int[] input)
	{
		int[] bytes = new int[Integer.MAX_VALUE / 32 + 1];
		int max = 0;

		for (int i : input)
		{
			if (max < i)
				max = i;

			int b = i / 32;
			int pos = i % 32 - 1;

			int bit = (1 << pos) & bytes[b];

			if (bit == 0)
				bytes[b] = (byte) (bytes[b] ^ (1 << pos));
		}

		int start = -1;
		int count = 0;
		int tmpStart = -1;
		int tmpCount = 0;

		for (int i = 1; i <= max; i++)
		{
			int b = i / 32;
			int pos = i % 32 - 1;

			int bit = (1 << pos) & bytes[b];

			if (bit != 0)
			{
				if (tmpStart == -1)
					tmpStart = i;
				tmpCount++;
			} else
			{
				if (tmpStart != -1)
				{
					if (tmpCount >= count)
					{
						start = tmpStart;
						count = tmpCount;
					}

					tmpStart = -1;
					tmpCount = 0;
				}
			}
		}

		if (tmpStart != -1 && tmpCount >= count)
		{
			start = tmpStart;
			count = tmpCount;
		}

		for (int i = 0; i < count; i++)
			System.out.print((start + i) + " ");

		System.out.println();
	}

	// O(1) space : DOESN'T WORK
	public void Find2(int[] input)
	{
		int min = Integer.MAX_VALUE;

		for (int i : input)
			if (i < min)
				min = i;

		for (int i = 0; i < input.length; i++)
		{
			int index = input[i] - min;

			while (index != i && input[i] != -1 && index < input.length)
			{
				if (input[index] == input[i])
				{
					input[i] = -1;
				} else
				{
					int tmp = input[index];
					input[index] = input[i];
					input[i] = tmp;
					index = input[i] - min;
				}
			}
		}

		System.out.println("Sorted: "+Arrays.toString(input));
		boolean start = false;
		int startIndex = -1;
		int count = 0;
		int tmp = -1;

		for (int i = 0; i < input.length; i++)
		{
			if (input[i] == -1)
			{
				if (start)
				{
					if ((i - tmp + 1) > count)
					{
						startIndex = tmp;
						count = (i - tmp);
					}

					start = false;
				}
			} else
			{
				if (!start)
				{
					start = true;
					tmp = i;
				}
			}
		}
		
		if(startIndex != -1)
		{
			for(int i = 0 ; i < count ; i++)
				System.out.print(input[startIndex]+i);
			
			System.out.println();
		}

	}

}
