package question;

import atom.*;
import datastructure.*;

public class FirstCommonAncestor
{

	public static void main(String[] args)
	{
		TreeNode t = BinaryTree.BuildTestTree();

		System.out.println(Find(t, new TreeNode(0), new TreeNode(10)).Data);
		System.out.println(Find(t, new TreeNode(1), new TreeNode(2)).Data);
		System.out.println(Find(t, new TreeNode(1), new TreeNode(3)).Data);
		System.out.println(Find(t, new TreeNode(4), new TreeNode(3)).Data);
		System.out.println(Find(t, new TreeNode(5), new TreeNode(3)).Data);
	}

	public static TreeNode Find(TreeNode tree, TreeNode n1, TreeNode n2)
	{
		if (tree == null)
			return null;
		
		if(tree.Data == n1.Data || tree.Data == n2.Data)
		{
			return tree;
		}

		boolean n1OnRight = IsCover(tree.Right, n1);
		boolean n2OnRight = IsCover(tree.Right, n2);
				
		if( n1OnRight == n2OnRight)
			return n1OnRight ? Find(tree.Right,n1,n2) : Find(tree.Left,n1,n2);
		else		
		{
			return tree;
		}
	}

	private static boolean IsCover(TreeNode tree, TreeNode n)
	{
		if (tree == null)
			return false;
		
		if(tree.Data == n.Data)
			return true;
		
		return IsCover(tree.Left, n) || IsCover(tree.Right, n);
	}

}
