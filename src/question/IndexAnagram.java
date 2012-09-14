package question;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.Test;

public class IndexAnagram
{
	/*
	 * Find a way to index a word so that anagrams have the same index
	 * */
	
	public int Index(String word)
	{
		int prime = 37; // a-z,0-9,_
		int[] coefficient = new int[37];

		for (char c : word.toCharArray())
		{
			if ((c - 'a') >= 0 && (c - 'a') <= 25)
			{
				coefficient[(c - 'a')]++;
			} else if ((c - '0') >= 0 && (c - '0') <= 9)
			{
				coefficient[(c - 'a') + 26]++;
			} else if (c == ' ')
				coefficient[36]++;
		}

		System.out
				.println(String.format("Input %s, Element %s", word, Arrays.toString(coefficient)));
		BigInteger index = new BigInteger("0");

		for (int i = 0; i < coefficient.length; i++)
		{
			if (coefficient[i] != 0)
			{
				BigInteger coe = new BigInteger(String.valueOf(coefficient[i]));
				BigInteger p = new BigInteger(String.valueOf(prime));
				BigInteger d = coe.multiply(p.pow(i));
				index = index.add(d);
			}
		}

		return index.mod(new BigInteger(String.valueOf(Integer.MAX_VALUE))).intValue();
	}

	@Test
	public void IndexTest()
	{
		System.out.println(Index("pot"));
		System.out.println(Index("top"));
		System.out.println(Index("opt"));
		System.out.println(Index("Hi Jerry,  Great to speak with you yesterday"));
	}

}
