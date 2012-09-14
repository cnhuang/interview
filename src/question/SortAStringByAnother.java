package question;

import org.junit.Test;
import java.util.*;

public class SortAStringByAnother
{
	/*
	 * @input: str1: target string, str2: sort string
	 * @output: sort str1 based on str2
	 * @Example: ("house","eho") -> ehous 
	 * */
	@Test
	public void SortTest()
	{
		Sort("todaysijdfkhske'lk;ld","askldjivu");
	}
	
	
	public void Sort(String target, String sort)
	{
		int[] charCount = new int[sort.toCharArray().length];
		HashMap<String,Integer> charIndex = new HashMap<String,Integer>(); 
		
		for(int i = 0 ; i < sort.length() ; i++)
		{
			String c = String.valueOf(sort.charAt(i));
			charIndex.put(c,i);
		}
		
		String tail = "";
		for(char c : target.toCharArray())
		{
			String s = String.valueOf(c);
			
			if(charIndex.containsKey(s))
				charCount[charIndex.get(s)]++;
			else
				tail += s;
		}
		
		for(int i = 0 ; i < sort.length() ; i++)
		{
			for(int j = 0 ; j < charCount[i]; j++)
				System.out.print(sort.charAt(i));
		}
		
		System.out.println(tail);
	}
	
}
