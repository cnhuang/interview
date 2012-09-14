package question.treeandgraph;

import datastructure.BinaryTree;
import atom.TreeNode;

public class BuildTreeWithMinHeight
{

	//Crack code interview p125
	public static void main(String[] args)
	{
		TreeNode t = GenerateTree(100);
		System.out.println(TreeHeight(t));		
		BinaryTree.Inorder(t);
	}
	
	public static TreeNode GenerateTree(int n)
	{		
		int[] arr = new int[n];
		
		for(int i = 0 ; i < n ; i++)
			arr[i] = i;		
		
		return Build(0,n-1,arr);		
	}
	
	public static TreeNode Build(int s, int e, int[] arr)
	{
		if(e < s)
			return null;
		
		int mid = ((e-s)/2)+s;
		
		TreeNode t = new TreeNode(arr[mid]);
		t.Left=(Build(s,mid-1,arr));
		t.Right=(Build(mid+1,e,arr));
		return t;
	}
	
	public static int TreeHeight(TreeNode t)
	{
		if(t == null)
			return 0;
		
		return 1+Math.max(TreeHeight(t.Left),TreeHeight(t.Right));
	}

}
