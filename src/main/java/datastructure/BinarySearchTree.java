package datastructure;

import atom.*;

public class BinarySearchTree {

	
	public static TreeNode BuildTestTree(int size)
	{
		return BuildTestTree(1,size);
	}
	
	private static TreeNode BuildTestTree(int s, int e)
	{
		if(e >= s)
		{
			int mid = (s+e)/2;
			TreeNode t = new TreeNode(mid);
			t.Left = BuildTestTree(s,mid-1);
			t.Right = BuildTestTree(mid+1,e);
			return t;
		}
		else
			return null;
	}
}
