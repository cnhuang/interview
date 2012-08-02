package question.bit;

import utility.UtilMgr;

public class NextNumHasSameOneBits
{

	// Crack code interview p245
	// Not finished
	public static void main(String[] args)
	{
		UtilMgr.PrintBits(31);
		UtilMgr.PrintBits(14);
		UtilMgr.PrintBits(31^14);
		
		int n = UtilMgr.BitStringToInt("011100");
		NextMax(n);
	}

	public static void NextMax(int n)
	{
		// from right to left, find the first 1, turn on the next 0
		// shift all ones that on the right of the one just turned on to the
		// right.

		int tmp = n;
		@SuppressWarnings("unused")
		int oneCount = 0;
		int count = 0;

		boolean flag = false;
		while (count < 32)
		{
			if (tmp % 2 == 1)
			{
				oneCount++;
				flag = true;
			}
			else
			{
				if (flag)
				{
					
					UtilMgr.PrintBits(n);									
					n |= 1 << count;
					UtilMgr.PrintBits(n);
					n &= ~0 << count;
					UtilMgr.PrintBits(n);
					UtilMgr.PrintBits(~0<<count);
					int mask2 = (~0 >> (5));
					UtilMgr.PrintBits(mask2);
					n |= mask2;
					UtilMgr.PrintBits(n);
					return;					
				}
			}
			
			tmp /= 2;
			count++;
		}

	}

	public static void NextMin(int n)
	{
		// from right to left, find the first 1, turn off the turn the previous
		// 0
		// shift all ones that on the right of the one just turned on to the
		// left.

	}

}
