package question.bit;

import utility.UtilMgr;

public class UpdateBit
{
	//crack code interview p133
	public static void main(String[] args)
	{		
		int n = UtilMgr.BitStringToInt("10000000011");
		//n = UtilMgr.BitStringToInt("111111111111");
		int m = UtilMgr.BitStringToInt("10101");
		
		Replace(n,m,2,6);
	}
	
	public static void Replace(int n,int m,int s, int e)
	{
		//all 1
		int mask = ~0;
		mask = mask << e+1;
		mask |= (1 << (s)) -1;			
		UtilMgr.PrintBits(n & mask | (m << (s)));
	}
}

