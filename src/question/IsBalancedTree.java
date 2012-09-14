package question;

import atom.*;
import datastructure.*;

public class IsBalancedTree
{

	public static void main(String[] args)
	{		
		System.out.println(M1(BinaryTree.BuildTestTree()));
		System.out.println(M1(BinaryTree.BuildRandomTree(10)));
	}
	
	public static boolean M1(TreeNode node)
	{
		int diff = Math.abs(M1_Support(node.Left)-M1_Support(node.Right));
		
		if(diff >= 0 && diff <= 1)
			return true;
		
		return false;
	}
	
	private static int M1_Support(TreeNode node)
	{
		if(node == null)
			return 0;
		
		int leftHeight = M1_Support(node.Left);
		
		if( leftHeight == -1)
			return -1;
		
		int rightHeight = M1_Support(node.Right);
		
		if(rightHeight == -1)
			return -1;
				
		if(Math.abs(leftHeight-rightHeight) <= 1)
		{
			return Math.max(leftHeight, rightHeight)+1;
		}
		else
			return -1;			
		
	}

}
