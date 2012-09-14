package question;

import java.util.HashSet;

import org.junit.Test;

public class VotingTheory
{
	/*
	 * Given an Array, find elements whose count > Array.length / N
	 */

	public void Find(int[] data, int N)
	{
		if(data == null || data.length == 0)
			throw new IllegalArgumentException();
		if(N < 1)
			throw new IllegalArgumentException();
		if(data.length == 1)
		{
			System.out.println(String.format("%d > 1/%d", data[0], N));	
		}
		if(data.length <= N || N == 1)			
		{
			throw new IllegalArgumentException("All distinct elements fit");
		}		
		
		HashSet<Integer> chosen = new HashSet<Integer>();

		for (int i = N; i > 1; i--)
		{
			int score = i - 1;
			int major = 0;
			int count = 0;
			for (int candidate : data)
			{
				if (!chosen.contains(candidate))
				{
					if (count == 0)
					{
						count += score;
						major = candidate;
					} else if (major == candidate)
					{
						count += score;
					} else
						count -= 1;
				}
			}

			if (count > 0)
			{
				int actualCount = 0;
				for (int candidate : data)
					if (candidate == major)
						actualCount++;

				if (actualCount > data.length / N)
				{
					System.out.println(String.format("%d > 1/%d", major, N));
				}
				chosen.add(major);
			} else
				return;
		}
	}

	@Test
	public void TestFind()
	{
		int[] data = { 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 1, 2, 1, 2, 4 };
		Find(data, 8);
	}
}
