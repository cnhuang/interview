package question;

import org.junit.Test;

public class PatternSearch
{
	/*
	 * http://www.careercup.com/question?id=13126665
	 * 
	 * You are given a 2D array of characters and a character pattern. WAP to
	 * find if pattern is present in 2D array. Pattern can be in any way (all 8
	 * neighbors to be considered) but you can’t use same character twice while
	 * matching. Return 1 if match is found, 0 if not.
	 */
	public boolean Search(char[][] arr, String target)
	{
		boolean[][] flag = new boolean[arr.length][arr.length];

		for (int x = 0; x < arr[0].length; x++)
			for (int y = 0; y < arr.length; y++)
				if (arr[y][x] == target.charAt(0))
					if (Search(arr, target, flag, x, y, 0))
						return true;

		return false;
	}

	public boolean Search(char[][] arr, String target, boolean[][] flag, int x, int y, int index)
	{
		if (index == target.length())
			return true;

		if (x >= arr[0].length)
			x %= arr[0].length;
		if (y >= arr.length)
			y %= arr.length;
		if (x < 0)
			x += arr[0].length;
		if (y < 0)
			y += arr.length;

		String key = x + "-" + y;
		if (flag[y][x])
			return false;

		boolean find = false;

		if (arr[y][x] == target.charAt(index))
		{
			System.out.println(String.format("[%d] Found %c in %s", index, target.charAt(index),
					key));
			flag[y][x] = true;

			for (int i = -1; i < 2 && !find; i++)
			{
				for (int j = -1; j < 2 && !find; j++)
				{
					find |= Search(arr, target, flag, x + j, y + i, index + 1);
				}
			}

			flag[y][x] = false;
		}

		return find;
	}

	@Test
	public void SearchTest()
	{
		char[][] arr = { { 'A', 'C', 'P', 'R', 'C' }, { 'X', 'S', 'O', 'P', 'C' },
				{ 'V', 'O', 'V', 'N', 'I' }, { 'W', 'G', 'F', 'M', 'N' },
				{ 'Q', 'A', 'T', 'I', 'T' } };

		String target = "MICROSOFT";

		System.out.println(Search(arr, target));
	}

}
