package interview.google;

import java.util.Arrays;

public class GenerateStringsForPhoneNumbers
{
	/*
	 * Using letters on the phone keyboard to generate all combinations of
	 * letters for an input phone number
	 */
	public void PhoneNumberStrings(int[] input)
	{
		char[] result = new char[input.length];
		PrintLetters(input, 0, result);
	}

	public void PrintLetters(int[] numbers, int index, char[] result)
	{

		// exception check
		if (numbers == null || numbers.length == 0 || index < 0)
		{
			throw new IllegalArgumentException();
		}

		// base condition
		if (index == numbers.length)
			System.out.println(Arrays.toString(result));

		else
		{
			char[] letters = GetLetters(numbers[index]);

			for (char c : letters)
			{
				result[index] = c;
				PrintLetters(numbers, index + 1, result);
			}
		}

	}

	public char[] GetLetters(int i)
	{
		switch (i)
		{
		case 2:
			return new char[] { 'a', 'b', 'c' };
		case 3:
			return new char[] { 'd', 'e', 'f' };
		case 4:
			return new char[] { 'g', 'h', 'i' };
		case 5:
			return new char[] { 'j', 'k', 'l' };
		case 6:
			return new char[] { 'm', 'n', 'o' };
		case 7:
			return new char[] { 'p', 'q', 'r', 's' };
		case 8:
			return new char[] { 't', 'u', 'v' };
		case 9:
			return new char[] { 'w', 'x', 'y', 'z' };
		default:
			return new char[] {};
		}

	}
}
