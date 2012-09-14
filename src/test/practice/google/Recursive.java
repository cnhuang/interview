package test.practice.google;

import java.util.Arrays;

import org.junit.*;

public class Recursive
{
	@Test
	public void PermutationTest()
	{
		System.out.println("=============== Permutation ===================");
		String target = "abc";
		Permutaion(target, 0, new char[target.length()], new boolean[target.length()]);
	}

	public void Permutaion(String str, int index, char[] result, boolean[] choice)
	{
		if (index == str.length())
		{
			System.out.println(Arrays.toString(result));
			return;
		}

		for (int i = 0; i < str.length(); i++)
		{
			if (!choice[i])
			{
				result[index] = str.charAt(i);
				choice[i] = true;
				Permutaion(str, index + 1, result, choice);
				choice[i] = false;
			}
		}

	}

	@Test
	public void PowerSetTest()
	{
		System.out.println("=============== PowerSetTest ===================");
		String target = "abc";
		PowerSet(target, 0, new char[target.length()]);
	}

	public void PowerSet(String str, int index, char[] choice)
	{
		if (str.length() == index)
		{
			System.out.println(Arrays.toString(choice));
		} else
		{
			PowerSet(str, index + 1, choice);
			choice[index] = str.charAt(index);
			PowerSet(str, index + 1, choice);
			choice[index] = ' ';
		}
	}

	@Test
	public void ChangeCoinsTest()
	{
		int[] coins = { 1, 2, 5, 10, 25 };
		int[] results = new int[coins.length];
		ChangeCoins(25, coins, results, 0);
	}

	public void ChangeCoins(int total, int[] coins, int[] results, int index)
	{		
		if (total == 0)
		{
			System.out.print(Arrays.toString(coins) + "=>");
			System.out.println(Arrays.toString(results));
			return;
		}

		if (total < 0 || index == coins.length)
			return;

		int remain = total;
		int count = 0;

		while (remain > 0)
		{
			results[index] = count++;	
			remain = total - results[index]*coins[index];
			ChangeCoins(remain, coins, results, index + 1);
			//total -=  coins[index];
		} 
		
		results[index] = 0;
	}
}
