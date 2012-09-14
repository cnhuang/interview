package test.practice;

import java.util.List;

import datastructure.*;
import atom.*;

public class Trees
{
	public static void main(String[] args)
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

		TreeNode t = Rebuild(pre, in, 0, in.size() - 1, 0);
		Preorder_Recursive(t);
		System.out.println();
		Inorder_Recursive(t);
		System.out.println();
	}

	public static TreeNode Rebuild(List<TreeNode> pre, List<TreeNode> in, int s, int e, int index)
	{
		TreeNode head = null;

		if (index < pre.size() && e >= s)
		{
			head = new TreeNode(pre.get(index).Data);
			for (int i = s; i <= e; i++)
			{
				if (in.get(i).Data == head.Data)
				{
					head.Left = Rebuild(pre, in, s, i - 1, ++index);
					head.Right = Rebuild(pre, in, i + 1, e, index + (i - s));
					break;
				}
			}
		}
		return head;

	}

	public static void Inorder(TreeNode head)
	{
		java.util.Stack<TreeNode> s = new java.util.Stack<TreeNode>();
		s.add(head);

		while (!s.isEmpty())
		{
			TreeNode n = s.peek();

			if (n.Left != null && !n.Left.IsVisited)
				s.add(n.Left);
			else
			{
				s.pop();
				n.IsVisited = true;
				System.out.print(n.Data + " ");
				if (n.Right != null && !n.Right.IsVisited)
				{
					s.add(n.Right);
				}
			}
		}

		System.out.println();
	}

	public static void Inorder_Recursive(TreeNode head)
	{
		if (head == null)
			return;

		Inorder_Recursive(head.Left);
		System.out.print(head.Data + " ");
		Inorder_Recursive(head.Right);

	}

	public static void Preorder(TreeNode head)
	{
		java.util.Stack<TreeNode> s = new java.util.Stack<TreeNode>();
		s.add(head);

		while (!s.isEmpty())
		{
			TreeNode t = s.peek();

			if (!t.IsVisited)
			{
				t.IsVisited = true;
				System.out.print(t.Data + " ");
			}

			if (t.Left != null && !t.Left.IsVisited)
				s.add(t.Left);
			else if (t.Right != null && !t.Right.IsVisited)
				s.add(t.Right);
			else
				s.pop();

		}
		System.out.println();
	}

	public static void Preorder_Recursive(TreeNode head)
	{
		if (head == null)
			return;

		System.out.print(head.Data + " ");
		Preorder_Recursive(head.Left);
		Preorder_Recursive(head.Right);
	}

	public static void Postorder(TreeNode head)
	{
		java.util.Stack<TreeNode> s = new java.util.Stack<TreeNode>();
		s.add(head);

		while (!s.isEmpty())
		{
			TreeNode t = s.peek();

			if (t.Left != null && !t.Left.IsVisited)
				s.add(t.Left);
			else if (t.Right != null && !t.Right.IsVisited)
				s.add(t.Right);
			else
			{
				t.IsVisited = true;
				System.out.print(t.Data + " ");
				s.pop();
			}
		}
		System.out.println();
	}

	public static void Postorder_Recursive(TreeNode head)
	{
		if (head == null)
			return;

		Postorder_Recursive(head.Left);
		Postorder_Recursive(head.Right);
		System.out.print(head.Data + " ");

	}
}
