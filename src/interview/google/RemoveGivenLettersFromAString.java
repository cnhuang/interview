package interview.google;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class RemoveGivenLettersFromAString
{
	/*
	 * Write a method to remove any given char ( let¡¦s say ¡§l¡¨) and how do you
	 * verify 2 l is removed from given string.	 */

	public String removeGivenChars(String str, HashSet<String> chars)
	{

		if (null == str || str == "")
			return str;
		if (chars == null || chars.size() == 0)
			return str;

		char[] result = new char[str.length()];
		int index = 0;

		for (char c : str.toCharArray())
		{
			if (!chars.contains(String.valueOf(c)))
			{
				result[index++] = c;
			}
		}

		return (new String(result)).trim();
	}

	// More test cases can be added such as null/empty input
	// and expected exception can be added to check the result.

	@Test
	public void removeGiveStringTest()
	{
		String str = "Hello World!!";
		HashSet<String> chars = new HashSet<String>();
		chars.add("l");

		String result = removeGivenChars(str, chars);

		int resultIndex = 0;

		// This test make sure given chars are removed and output chars
		// maintains the original order of input chars

		// go through each char in the input string
		for (int i = 0; i < str.length(); i++)
		{
			char c = str.charAt(i);
			// if the char should be removed, by pass it
			if (chars.contains(String.valueOf(c)))
				continue;
			else
			{
				// else, the char should be equal to the char in the
				// corresponding position of the result string
				Assert.assertEquals(c, result.charAt(resultIndex++));
			}

		}

		// make sure reaches the end of result string
		Assert.assertEquals(resultIndex, result.length());

	}
}
