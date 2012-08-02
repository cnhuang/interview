package question;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

public class UnconcatenatingString
{

	/*
	 * Original Question: Given a string and a dictionary, find meaningful ways
	 * to unconcatenate the string
	 * 
	 * Variation: Given a string of digits, parse the digits in to numbers which
	 * are smaller than N
	 */

	public HashSet<String> Parse(String str, int N)
	{
		HashSet<String> result = new HashSet<String>();

		if (str == null || str.length() == 0)
			return result;

		int num = Integer.parseInt(str);
		if (num < N)
			result.add(str);

		for (int i = 1; i < str.length(); i++)
		{
			String prefix = str.substring(0, i);
			String suffix = str.substring(i);

			HashSet<String> r1 = Parse(prefix, N);
			HashSet<String> r2 = Parse(suffix, N);

			if (r1.size() > 0 && r2.size() > 0)
			{
				for (String s1 : r1)
					for (String s2 : r2)
					{
						if (!result.contains(s1 + " " + s2))
							result.add(s1 + " " + s2);
					}
			}
		}

		return result;
	}

	@Test
	public void ParseTest()
	{
		HashSet<String> result = Parse("123456678", 25);
		String[] strs = new String[result.size()];
		result.toArray(strs);
		Arrays.sort(strs);

		for (String s : strs)
			System.out.println(s);
	}
	

}
