package dynamicpg;

import java.math.BigInteger;
import java.util.Hashtable;

public class MoveRobot
{	
	
	public static void main(String[] args)
	{
		int x = 20;
		int y = 20;
		System.out.println(MoveTo2(x,y,new Hashtable<String,BigInteger>()));
		System.out.println(MoveTo(x,y));
		
	}
	
	
	public static int MoveTo(int x, int y)
	{
		if(x < 0 || y < 0)
			return 0;
		
		if(x == 0 && y == 0)
			return 1;
		
		return MoveTo(x-1,y)+MoveTo(x,y-1);
	}
	
	public static BigInteger MoveTo2(int x, int y, Hashtable<String,BigInteger> ht)
	{	
		if(x < 0 || y < 0)
			return BigInteger.valueOf(0);
		
		if(x == 0 && y == 0)
			return BigInteger.valueOf(1);
		
		String key = x+"-"+y;
		if(ht.containsKey(key))
		{
			//System.out.println(key);		
			return ht.get(key);
		}
		else
		{
			//System.out.println(key);	
			ht.put(key,MoveTo2(x-1,y,ht).add(MoveTo2(x,y-1,ht)));
			return ht.get(key);
		}
	}

}

