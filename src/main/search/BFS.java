package search;

import datastructure.*;
import atom.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BFS
{
	public static void main(String[] args)
	{
		TreeNode t = BinaryTree.BuildTestTree();
		BFS_Basic(t);
		BFS_ByLevel(t);
		BFS_ByLevelReverse(t);
	}

	public static void BFS_Basic(TreeNode t)
	{
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(t);

		while (q.size() > 0)
		{
			TreeNode n = q.poll();
			System.out.print(n.Data + ",");

			if (n.Left != null)
				q.add(n.Left);

			if (n.Right != null)
				q.add(n.Right);
		}

		System.out.println();
		System.out.println();
	}

	public static void BFS_ByLevel(TreeNode t)
	{
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();

		q1.add(t);

		while (q1.size() > 0)
		{
			TreeNode n = q1.poll();
			if (n.Left != null)
				q2.add(n.Left);
			if (n.Right != null)
				q2.add(n.Right);
			System.out.print(n.Data + ",");

			if (q1.size() == 0)
			{
				System.out.println();
				Queue<TreeNode> q3 = q1;
				q1 = q2;
				q2 = q3;
			}
		}
		System.out.println();
	}
	

	public static void BFS_ByLevelReverse(TreeNode t)
	{
		java.util.Stack<TreeNode> s1 = new java.util.Stack<TreeNode>();
		java.util.Stack<TreeNode> s2 = new java.util.Stack<TreeNode>();

		s1.add(t);

		boolean flag = true;

		while (s1.size() > 0)
		{
			TreeNode n = s1.pop();
			if (flag)
				if (n.Left != null)
					s2.add(n.Left);
			
			if (n.Right != null)
				s2.add(n.Right);
			
			if (!flag)
				if (n.Left != null)
					s2.add(n.Left);
			System.out.print(n.Data + ",");

			if (s1.size() == 0)
			{
				System.out.println();
				java.util.Stack<TreeNode> s3 = s1;
				s1 = s2;
				s2 = s3;
				flag = !flag;
			}
		}
		System.out.println();
	}
}
