package test;

import org.junit.Test;

public class General
{

	@Test
	public void Bit()
	{
		System.out.println((Integer.MAX_VALUE >> 31) & 1);
		System.out.println((Integer.MIN_VALUE >> 31) & 1);
		System.out.println((1 >> 31) & 1);
		System.out.println((-1 >> 31) & 1);
		
		for(int i = 0 ; i < 32 ; i++)
		{
			int t = (int) Math.pow(2, i);
			System.out.println(i+"=>"+t);
		}
		
		System.out.println(Integer.MAX_VALUE );
		System.out.println(Integer.MIN_VALUE );
	}
}
