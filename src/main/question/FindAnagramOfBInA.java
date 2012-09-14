package question;

import java.util.*;

import org.junit.Test;

public class FindAnagramOfBInA
{

	/*
	 * http://www.careercup.com/question?id=8684685
	 * 
	 * you are given two arrays. A of size n, B of size m. m is a very very
	 * small number compared to n. find out if A contains a substring which is
	 * anagram of B.
	 */

	
	
	public void Find(String A, String B)
	{
		HashMap<String, Integer> count = GetCountTable(B);

		int s = 0;

		for (int e = 0; e < A.length(); e++)
		{
			String E = String.valueOf(A.charAt(e));

			if (count.containsKey(E))
			{
				count.put(E, count.get(E) - 1);
				if ((e - s) == B.length()-1)
				{
					boolean found = true;
					for (String k : count.keySet())
					{
						if (count.get(k) != 0)
						{
							found = false;
							break;
						}
					}

					if (found)
					{
						System.out.println(A.substring(s, e + 1));
					}
					
					String S = String.valueOf(A.charAt(s));
					count.put(S, count.get(S) + 1);
					s++;
				}
			} else
			{
				s = e+1;
				count = GetCountTable(B);
			}
		}
	}

	public HashMap<String, Integer> GetCountTable(String s)
	{
		HashMap<String, Integer> count = new HashMap<String, Integer>();

		for (char c : s.toCharArray())
		{
			String C = String.valueOf(c);

			if (count.containsKey(C))
				count.put(C, count.get(C) + 1);
			else
				count.put(C, 1);
		}

		return count;
	}

	@Test
	public void FindTest()
	{
		String A = "ghefdckjcaaadebcclpq";
		String B = "aabedcca";
		Find(A,B);
	}
}
