package question;

import java.util.Arrays;

public class Anagrams
{

	//Crack code interview p99
	public static void main(String[] args)
	{
		String s1 = "abcdeabcdeabcde";
		String s2 = "abcdeabcdeabcde";
		System.out.println(M_Array(s1,s2));
		System.out.println(M_Sort(s1,s2));
	}
	
	public static boolean M_Array(String s1, String s2)
	{
		if(s1.length() != s2.length())
			return false;
		
		int[] array = new int[26];
		
		for(int i = 0 ; i < s1.length() ; i++)
			array[s1.charAt(i)-'a']++;
		
		for(int i = 0 ; i < s2.length() ; i++)
		{
			if(--array[s2.charAt(i)-'a'] < 0)
				return false;
		}
		
		for(int i : array)
			if(i != 0 )
				return false;
		
		return true;
	}

	public static boolean M_Sort(String s1, String s2)
	{
		char[] c1 = s1.toCharArray();
		Arrays.sort(c1);
		char[] c2 = s2.toCharArray();
		Arrays.sort(c2);		
		return String.valueOf(c1).equals(String.valueOf(c2));
	}
}
