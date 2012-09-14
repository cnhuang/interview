package dynamicpg;

import java.math.BigInteger;
import java.util.Hashtable;

public class RunUpStairs
{

	
	public static void main(String[] args)
	{
		int n = 100;
		System.out.println(CountWays2(n,new Hashtable<Integer,BigInteger>()));
		System.out.println(CountWays(n));
	}
	
	public static int CountWays(int n)
	{
		if( n < 0 )
			return 0;
		else if( n == 0)
			return 1;
		else
			return CountWays(n-1)+CountWays(n-2)+CountWays(n-3);
	}
	
	public static BigInteger CountWays2(int n, Hashtable<Integer,BigInteger> ht)
	{
		if( n < 0 )
			return new BigInteger("0");
		else if( n == 0)
			return new BigInteger("1");
		else if (ht.containsKey(n))
			return ht.get(n);
		else
		{
			ht.put(n,CountWays2(n-1,ht).add(CountWays2(n-2,ht)).add(CountWays2(n-3,ht)));
			return ht.get(n);
		}
	}

}
