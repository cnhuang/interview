package question;

import java.util.*;

import org.junit.Test;

public class FindLongestRepeatingSubstring
{
	public void Find(String str)
	{
		// Build Suffix Tree

		SuffixTreeNode head = new SuffixTreeNode();
		for (int i = 0; i < str.length(); i++)
			head.BuildTree(str.substring(i));

		Stack<SuffixTreeNode> stack = new Stack<SuffixTreeNode>();
		stack.add(head);
		String maxStr = "";
		String tmpStr = "";

		while (!stack.isEmpty())
		{
			SuffixTreeNode node = stack.peek();
			SuffixTreeNode child = node.GetNextUnVisitedChild();

			if (child != null)
			{
				tmpStr += child.Char;
				stack.add(child);
			} else
			{
				node.IsVisited = true;
				if (node != head)
				{
					if (node.Count > 1 && tmpStr.length() > maxStr.length())
					{
						maxStr = tmpStr;
					}
				}
				if (tmpStr.length() > 0)
					tmpStr = tmpStr.substring(0, tmpStr.length() - 1);
				stack.pop();
			}
		}

		System.out.println("str=" + maxStr);
	}

	@Test
	public void FindTest()
	{
		Find("ababab");
	}
}

class SuffixTreeNode
{
	public char Char;
	private SuffixTreeNode[] children = new SuffixTreeNode[256];
	public int Count = 0;
	boolean IsVisited = false;

	public SuffixTreeNode(char c)
	{
		Char = c;
	}

	public SuffixTreeNode()
	{

	}

	public SuffixTreeNode GetChild(char c)
	{
		return children[c];
	}

	public void BuildTree(String s)
	{
		if (s == null || s.length() < 1)
			return;

		char c = s.charAt(0);

		SuffixTreeNode child = children[c];
		if (child == null)
		{
			child = new SuffixTreeNode(c);
			children[c] = child;
		}

		child.Count++;
		child.BuildTree(s.substring(1));
	}

	public SuffixTreeNode GetNextUnVisitedChild()
	{
		for (SuffixTreeNode node : children)
			if (node != null && !node.IsVisited)
				return node;

		return null;
	}
}
