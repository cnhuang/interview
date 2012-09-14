package question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class WordTransformer
{
	/*
	 * @input: word1, word2
	 * 
	 * @output: shortest path of transforming word1 to word2 by switching one
	 * letter per step
	 */

	@Test
	public void BFSWordTransformerTest()
	{
		BFSWordTransformer("cat", "dog");
	}

	public void BFSWordTransformer(String word1, String word2)
	{
		List<WordNode> data = new ArrayList<WordNode>();
		data.add(new WordNode(word1.toLowerCase(), null));
		WordNode wn = BFSWordTransformerHelper(data, word2.toLowerCase(), new HashSet<String>());

		while (wn != null)
		{
			System.out.print(wn + "<-");
			wn = wn.Parent;
		}
		System.out.println();
	}

	public WordNode BFSWordTransformerHelper(List<WordNode> candidate, String word2,
			HashSet<String> cache)
	{
		System.out.println(candidate.size()+":"+candidate);
		List<WordNode> newCandidate = new ArrayList<WordNode>();

		for (WordNode wn : candidate)
		{
			char[] chars = wn.Word.toCharArray();

			for (int i = 0; i < wn.Word.length(); i++)
			{
				char tmpChar = chars[i];
				for (char c = 'a'; c <= 'z'; c++)
				{
					chars[i] = c;
					String tmp = String.valueOf(chars);
					
					if (!cache.contains(tmp) && atom.Dictionary.IsWord(tmp))
					{
						WordNode n = new WordNode(tmp, wn);
						
						if (tmp.equals(word2))
							return n;
						
						newCandidate.add(n);
						cache.add(tmp);
					}
				}
				chars[i] = tmpChar;
			}
		}

		if (newCandidate.size() > 0)
			return BFSWordTransformerHelper(newCandidate, word2, cache);

		return null;
	}

	@Test
	public void DFSWordTransformerTest()
	{
		DFSWordTransformer("cat".toCharArray(), "dog".toCharArray(), new ArrayList<String>());
	}

	// Not the shortest path
	public void DFSWordTransformer(char[] orig, char[] target, ArrayList<String> result)
	{
		if (orig == target)
		{
			System.out.println(result);
		}

		for (int i = 0; i < orig.length; i++)
		{
			char temp = orig[i];
			for (char ch = 'a'; ch <= 'z'; ch++)
			{				
				orig[i] = ch;
				String currWord = String.valueOf(orig);

				if (atom.Dictionary.IsWord(currWord) && !result.contains(currWord))
				{
					result.add(currWord);
					DFSWordTransformer(orig, target, result);
					//result.remove(currWord);
				}
			}
			orig[i] = temp;
		}
	}

}

class WordNode
{
	String Word;
	WordNode Parent;

	public WordNode(String word, WordNode parent)
	{
		Word = word;
		Parent = parent;
	}

	public String toString()
	{
		return Word;
	}
}
