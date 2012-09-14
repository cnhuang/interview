package question.amazon;

import java.util.List;

import search.BFS;

import datastructure.BinaryTree;
import atom.TreeNode;

public class CartesianTree
{

	//http://www.careercup.com/question?id=12715683
	public static void main(String[] args)
	{
		TreeNode t = BinaryTree.BuildTestTree();
		List<TreeNode> ns = BinaryTree.Inorder(t);		
		BFS.BFS_ByLevel(Build(ns));
	}
	
	public static TreeNode Build(List<TreeNode> t)
	{
		if(t == null || t.size() == 0)
		{
			return null;
		}
		
		return Build(t,0,t.size()-1);
	}
	
	public static TreeNode Build(List<TreeNode> t, int s, int e)
	{
		if(e == s)
			return new TreeNode(t.get(e).Data);
		else if(e < s)
			return null;
		else
		{
			int min = t.get(s).Data;
			int minIndex = s;
			
			for(int i = s+1 ; i <= e ; i++)
			{
				if(min > t.get(i).Data)
				{
					min = t.get(i).Data;
					minIndex = i;
				}
			}
			
			TreeNode n = new TreeNode(min);
			n.Left = Build(t,s,minIndex-1);
			n.Right = Build(t,minIndex+1,e);
			return n;
		}
	}

}
