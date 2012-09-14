package question;

import java.util.Arrays;

public class MoneyChange
{

	//crack code interview p.176
	public static void main(String[] args)
	{
		//System.out.println(Change(100, 25, ""));
		M2(new int[]{2,3,7},100,new int[3],0);
	}

	public static int Change(int n, int coin, String str)
	{
		int count = 0;

		if (coin == 1)
		{
			System.out.println(str+"1*"+n);
			return 1;
		}

		int coinCount = 0;
		while (n-(coinCount*coin) >= 0)
		{			
			count += Change(n - coin*coinCount, NextCoin(coin),str + coin+" * "+coinCount+", ");
			coinCount++;			
		}

		return count;
	}

	public static int NextCoin(int coin)
	{
		switch (coin)
		{
		case 25:
			return 10;
		case 10:
			return 5;
		case 5:
			return 1;
		default:
			return 1;
		}
	}

	public static void M2(int[] arr, int num, int[] result, int cursor)
	{
		if(num == 0)
		{
			System.out.print(Arrays.toString(arr)+"=>");
			System.out.println(Arrays.toString(result));
			return;
		}
		
		if(cursor >= arr.length || num < 0)
			return;
		
		int count = 0;
		
		while(num >= 0)
		{	
			result[cursor] = count++;			
			M2(arr,num,result,cursor+1);
			num -= arr[cursor];
		}
	}
	
}
