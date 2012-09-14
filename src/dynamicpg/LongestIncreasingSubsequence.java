package dynamicpg;

import java.util.ArrayList;
import java.util.Hashtable;

public class LongestIncreasingSubsequence
{

	public static void main(String[] args)
	{
		int[] arr = { 13, 14, 10, 11, 9, 30, 13, 31, 12, 14, 33, 1 };
		Find(arr);
	}

	// N^2 time
	public static void Find(int[] input)
	{
		Hashtable<Integer, ArrayList<Integer>> map = new Hashtable<Integer, ArrayList<Integer>>();
		ArrayList<Integer> max = new ArrayList<Integer>();
		for (int i = 0; i < input.length; i++)
		{
			ArrayList<Integer> r = Find(input, i, map);
			if (r.size() > max.size())
				max = r;
		}

		for (int i : max)
			System.out.print(input[i] + " ");
	}

	private static ArrayList<Integer> Find(int[] input, int index,
			Hashtable<Integer, ArrayList<Integer>> map)
	{
		if (map.containsKey(index))
			return map.get(index);

		ArrayList<Integer> max = new ArrayList<Integer>();

		for (int i = index - 1; i >= 0; i--)
		{
			if (input[i] < input[index])
			{
				ArrayList<Integer> tmp = Find(input, i, map);
				if (tmp.size() > max.size())
				{
					max = new ArrayList<Integer>();
					max.addAll(tmp);
				}
			}
		}

		max.add(index);
		map.put(index, max);

		return max;
	}

	// Nlogn Time

}
