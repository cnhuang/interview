package question;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class ShiftZerosToTheRight
{
	/*
	 * @input 34798201293083749
	 */

	@Test
	public void ShiftTest()
	{
		Random rand = new Random(System.currentTimeMillis());
		int N = 10;
		int[] data = new int[10];
		
		for(int i = 0 ; i < N ; i++)
			data[i] = rand.nextInt(10);
		
		Shift(data);
	}

	public void Shift(int[] digits)
	{
		System.out.println(Arrays.toString(digits));
		int zeroIndex = -1;
		
		for (int i = 0; i < digits.length; i++)
		{
			if (digits[i] == 0 && zeroIndex == -1)
				zeroIndex = i;
			else if(digits[i] != 0 && zeroIndex != -1)
			{
				int tmp = digits[i];
				digits[i] = digits[zeroIndex];
				digits[zeroIndex] = tmp;
				zeroIndex = i;
			}
		}
		System.out.println(Arrays.toString(digits));
	}
}
