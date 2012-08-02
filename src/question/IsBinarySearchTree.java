package question;

import atom.*;
import datastructure.*;

public class IsBinarySearchTree
{
	public static void main(String[] args)
	{
		TreeNode t = BinarySearchTree.BuildTestTree(20);
		TreeNode t2 = BinaryTree.BuildTestTree();
		System.out.println(M1(t));
		System.out.println(M1(t2));
		
		System.out.println(M2(t,Integer.MIN_VALUE,Integer.MAX_VALUE));
		System.out.println(M2(t2,Integer.MIN_VALUE,Integer.MAX_VALUE));
	}
	
	private static int M1_LastNumber = Integer.MIN_VALUE;	
	public static boolean M1(TreeNode node)
	{
		if(node == null)
			return true;
		
		if(!M1(node.Left))
			return false;
		
		if(node.Data >=M1_LastNumber )
			M1_LastNumber = node.Data;
		else
			return false;
		
		if(!M1(node.Right))
			return false;
		
		return true;
	}

	
	public static boolean M2(TreeNode node, int min, int max)
	{
		if(node == null)
			return true;
		
		if(node.Data < min || node.Data > max)
			return false;
		
		return M2(node.Left,min,node.Data) && M2(node.Right,node.Data,max);
	}
	
	
}
