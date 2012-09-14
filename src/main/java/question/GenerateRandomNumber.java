package question;

import org.junit.Test;
import java.util.*;

public class GenerateRandomNumber
{

	/*
	 * http://www.careercup.com/question?id=9865865
	 * 
	 * k distinct integers [0, N) Select a random no [0,N) which is not in this
	 * k distinct list.
	 * 
	 * Example: [4, 6, 9] Choose a random no between 0 - 9 which is not 4, or 6,
	 * or 9. Valid output: 2 Invalid output: 6
	 */

	Random rand = new Random(System.currentTimeMillis());

	public int Generate(int n, int arr[], int r)
	{
		//r = rand.nextInt(n-arr.length);
		System.out.println("r=" + r);

		for (int i = 0; i < arr.length; i++)
		{
			int space = arr[i] - i;
			if (space > r)
			{
				System.out.println(String.format("index=%d num=%d space=%d", i, arr[i], space));
				return arr[i] - (space - r);
			}
		}

		int space = n - arr.length;
		if (space > r)
		{
			System.out.println(String.format("num=%d space=%d", n, space));
			return n - (space - r);
		}

		return -1;
	}

	@Test
	public void GenerateTest()
	{
		int[] k = {1, 4, 6, 8 };
		for (int i = 0; i < 12; i++)
		{			
			System.out.println(Generate(10, k, i));
		}
	}
}
