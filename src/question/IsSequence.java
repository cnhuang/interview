package question;

import java.util.Arrays;

import org.junit.Test;

public class IsSequence
{
	/*
	 * @Input: integer array w/o duplicate numbers
	 * 
	 * @Output: boolean, if the input are continuous numbers
	 */

	@Test
	public void CheckTest()
	{
		int[][] TestData =
			{
				{ 1, 2, 3, 4, 5 },
				{ 5, 4, 3, 2, 1 },
				{ 1, 1, 1, 1, 1 },
				{},
				{ 100, 1, 2, 3, 5, 6, 0 }
			};
	
		for(int[] data : TestData)
		{
			System.out.println(Check(data));
			System.out.println(CheckWithSwap(data));
		}

	}

	public boolean CheckWithSwap(int[] data)
	{
		System.out.println("CheckWithSwap Input: " + Arrays.toString(data));
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i : data)
		{
			if (max < i)
				max = i;
			if (min > i)
				min = i;
		}

		for (int i = 0; i < data.length; i++)
		{
			int index = data[i] - min;

			while (index != i && data[i] != -1 && index < data.length)
			{
				if (data[index] != data[i])
				{
					int tmp = data[index];
					data[index] = data[i];
					data[i] = tmp;
					index = data[i] - min;
				} else
				{
					data[i] = -1;
				}
			}
		}

		System.out.println("Sorted: " + Arrays.toString(data));
		boolean end = false;
		for (int i = 0; i < data.length; i++)
		{
			if (!end)
			{
				if (data[i] == -1)
					end = true;
				else
				{
					if (i != 0)
					{
						if (data[i] - data[i - 1] != 1)
							return false;
					}
				}
			} else
			{
				if (end && data[i] != -1)
					return false;
			}
		}

		return true;
	}

	//Better solution
	public boolean Check(int[] data)
	{		
		System.out.println("Check Input: " + Arrays.toString(data));
		
		if(data.length < 2)
			return true;
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i : data)
		{
			if (max < i)
				max = i;
			if (min > i)
				min = i;
		}
		
		if(max-min > data.length)
			return false;
		
		boolean[] flags = new boolean[max-min+1]; 
		
		for(int i : data)
		{
			flags[i-min] = true;
		}
		
		for(boolean f : flags)
			if(!f)
				return false;
		
		return true;
		
	}

}
