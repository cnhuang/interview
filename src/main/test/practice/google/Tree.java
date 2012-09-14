package test.practice.google;

import java.util.List;
import java.util.Stack;

import datastructure.BinaryTree;
import atom.TreeNode;

public class Tree
{
	public static void main(String[] argv)
	{
		List<TreeNode> in = BinaryTree.Inorder(BinaryTree.BuildTestTree());
		Inorder(BinaryTree.BuildTestTree());
		Inorder_Recursive(BinaryTree.BuildTestTree());
		System.out.println();

		List<TreeNode> pre = BinaryTree.Preorder(BinaryTree.BuildTestTree());
		Preorder(BinaryTree.BuildTestTree());
		Preorder_Recursive(BinaryTree.BuildTestTree());
		System.out.println();

		List<TreeNode> post = BinaryTree.Postorder(BinaryTree.BuildTestTree());
		Postorder(BinaryTree.BuildTestTree());
		Postorder_Recursive(BinaryTree.BuildTestTree());
		System.out.println();
		System.out.println();

		TreeNode t = Rebuild(pre, in, 0, 0 , pre.size()-1);
		Preorder_Recursive(t);
		System.out.println();
		Inorder_Recursive(t);
		System.out.println();
	}
	
	
	public static void Inorder(TreeNode n)
	{		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(n);
		
		while(!stack.isEmpty())
		{
			TreeNode node = stack.peek();
			if(node.Left != null && !node.Left.IsVisited)
				stack.add(node.Left);
			else
			{
				System.out.print(node.Data+" ");
				node.IsVisited = true;
				stack.pop();
				
				if(node.Right != null && !node.Right.IsVisited)
					stack.add(node.Right);
			}
			
		}
		System.out.println();
	}
	
	public static void Inorder_Recursive(TreeNode n)
	{
		if(n == null)
			return;
		Inorder_Recursive(n.Left);
		System.out.print(n.Data+" ");
		Inorder_Recursive(n.Right);
	}
	
	public static void Preorder(TreeNode n)
	{
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(n);
		
		while(!stack.isEmpty())
		{
			TreeNode node = stack.peek();
			if(!node.IsVisited)
			{
				node.IsVisited = true;
				System.out.print(node.Data+" ");
			}
			
			if(node.Left != null && !node.Left.IsVisited)
				stack.add(node.Left);
			else if(node.Right != null && !node.Right.IsVisited)
				stack.add(node.Right);
			else
				stack.pop();
		}
		System.out.println();
	}
	
	public static void Preorder_Recursive(TreeNode n)
	{
		if(n == null)
			return;
		System.out.print(n.Data+" ");
		Preorder_Recursive(n.Left);		
		Preorder_Recursive(n.Right);
	}
	
	public static void Postorder(TreeNode n)
	{
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(n);
		
		while(!stack.isEmpty())
		{
			TreeNode node = stack.peek();
			if(node.Left != null && !node.Left.IsVisited)
				stack.add(node.Left);
			else if(node.Right != null && !node.Right.IsVisited)
				stack.add(node.Right);
			else
			{
				System.out.print(node.Data+" ");
				node.IsVisited = true;
				stack.pop();
			}
			
		}
		System.out.println();
	}
	
	public static void Postorder_Recursive(TreeNode n)
	{
		if(n == null)
			return;
		Postorder_Recursive(n.Left);		
		Postorder_Recursive(n.Right);
		System.out.print(n.Data+" ");
	}
	
	public static TreeNode Rebuild(List<TreeNode> pre, List<TreeNode> in,int index, int s , int e)
	{
		if(s > e)
			return null;
		
		TreeNode head = new TreeNode(pre.get(index).Data);
		
		for(int i = s ; i <= e ; i++)
			if(head.Data == in.get(i).Data)
			{
				head.Left = Rebuild(pre, in, index+1, s, i-1 );
				int leftCount = i-s;
				head.Right = Rebuild(pre, in, index+leftCount+1, i+1, e );
			}
		
		return head;
	}
}
