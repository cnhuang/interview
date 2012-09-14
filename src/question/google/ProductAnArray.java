package question.google;

import java.util.Arrays;

import org.junit.Test;

public class ProductAnArray
{
	/*
	 * Given an array of numbers, replace each number with the product of all
	 * the numbers in the array except the number itself *without* using
	 * division.
	 * 
	 * O(N)
	 */

	public void Calculate(int[] data)
	{
		int[] result = new int[data.length];
		result[0] = 1;
		int tmp = 1;

		for (int i = 1; i < data.length; i++)
		{
			tmp *= data[i - 1];
			result[i] = tmp;
		}

		tmp = 1;

		for (int i = data.length - 2; i >= 0; i--)
		{
			tmp *= data[i + 1];
			result[i] *= tmp;
		}

		System.out.println(Arrays.toString(result));
	}

	@Test
	public void CalculateTest()
	{
		int[] data = {1,2,3,4,5,6,7,8,9};
		Calculate(data);
	}
}
