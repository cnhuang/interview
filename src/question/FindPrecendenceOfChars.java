package question;

import org.junit.Test;
import java.util.*;

public class FindPrecendenceOfChars
{

	/*
	 * http://www.careercup.com/question?id=13394663
	 * 
	 * @input: sorted strings
	 * 
	 * @output: based on strings find the order of chars
	 * 
	 * @use topology sort
	 */

	@Test
	public void FindTest()
	{
		List<String> words = atom.Dictionary.GetWords();
		//System.out.println(words);
		String[] strs = new String[words.size()];
		Find(words.toArray(strs));
	}

	public void Find(String[] strs)
	{
		HashMap<String, HashSet<String>> graph = new HashMap<String, HashSet<String>>();

		//Create Graph based on strings
		System.out.println("Create Graph based on strings");
		for (int i = 0; i < strs.length - 1; i++)
		{
			String str1 = strs[i];
			String str2 = strs[i + 1];

			int index = 0;

			while (index < str1.length() && index < str2.length())
			{
				String char1 = String.valueOf(str1.charAt(index));
				String char2 = String.valueOf(str2.charAt(index));

				if (!char1.equals(char2))
				{
					if (!graph.containsKey(char1))
						graph.put(char1, new HashSet<String>());
				
					if (!graph.containsKey(char2))
						graph.put(char2, new HashSet<String>());

					HashSet<String> set = null;
					set = graph.get(char1);

					if(!set.contains(char2))
						set.add(char2);
					
					break;
				}
				
				index++;
			}
		}
		
		//Topology sort
		System.out.println("Topology sort");
		while(graph.size() != 0)
		{
			//Find chars with input
			HashSet<String> charsWithInput = new HashSet<String>();
			for(String c : graph.keySet())
			{
				for(String c2 : graph.get(c))
				{
					if(!charsWithInput.contains(c2))
						charsWithInput.add(c2);
				}
			}
			
			//Find chars without input
			List<String> selected = new ArrayList<String>();			
			for(String c : graph.keySet())
			{
				if(!charsWithInput.contains(c))
				{
					System.out.print(c);
					selected.add(c);
				}
			}
			
			//remove selected char
			for(String c : selected)
				graph.remove(c);			
		}
		
		System.out.println();
	}
}
