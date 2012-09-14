package question.amazon;

import search.BFS;
import datastructure.BinaryTree;
import atom.TreeNode;

public class Tree1
{
	//http://www.careercup.com/question?id=12691679
	//Make each node in the tree is equal to sum of its all descendants and the leafs are assigned value 0

	public static void main(String[] args)
	{
		TreeNode t = BinaryTree.BuildTestTree();
		BFS.BFS_ByLevel(t);		
		Sum(t);
		BFS.BFS_ByLevel(t);
	}
	
	public static int Sum(TreeNode t)
	{
		if(t == null)
			return 0;	
		
		int sum = t.Data + Sum(t.Left ) + Sum(t.Right);
		t.Data = sum - t.Data;
		
		return sum;
	}
	
	

}
