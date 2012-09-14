package question;

import java.util.Stack;

import datastructure.BinaryTree;
import atom.TreeNode;

public class MergeBST
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		TreeNode t1 = GetTestData(true);
		TreeNode t2 = GetTestData(false);

		BinaryTree.Inorder(t1);
		BinaryTree.Inorder(t2);

		BinaryTree.Inorder(Merge(t1, t2));
	}

	// Insert Tree2 to Tree1
	public static TreeNode Merge(TreeNode t1, TreeNode t2)
	{
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();

		s1.add(t1);
		s2.add(t2);
		ToMin(s1);
		ToMin(s2);
		
		TreeNode head = null;

		while (!s1.empty() || !s2.empty())
		{
			
			TreeNode n1 = null;
			TreeNode n2 = null;

			if (!s1.empty())
				n1 = s1.peek();

			if (!s2.empty())
				n2 = s2.peek();

			TreeNode minNode = null;

			if (n1 == null)
				minNode = n2;
			else if (n2 == null)
				minNode = n1;
			else if (n2.Data < n1.Data)
				minNode = n2;
			else
				minNode = n1;

			minNode.IsVisited = true;
			
			if (head == null)
			{
				head = minNode;
			} else
			{
				if (head.Data > minNode.Data)
				{
					minNode.Left = head.Left;
					head.Left = minNode;
				} else
				{
					minNode.Left = head;
					head = minNode;
				}
			}
			
			ToMin(s1);
			ToMin(s2);

		}
		
		TreeNode t = head;
		while(t != null)
		{
			t.IsVisited = false;
			t.Right = null;
			t = t.Left;			
		}

		return head;

	}

	public static void ToMin(Stack<TreeNode> s)
	{
		while (!s.empty())
		{
			TreeNode n = s.peek();
			if (n.Left != null && !n.Left.IsVisited)
			{
				s.add(n.Left);
			} else if (!n.IsVisited)
			{
				return;
			} else if (n.Right != null && !n.Right.IsVisited)
			{
				s.add(n.Right);
			} else
			{
				s.pop();
			}
		}
	}

	public static TreeNode GetTestData(boolean oddNumbers)
	{

		int start = oddNumbers ? 1 : 2;

		TreeNode head = new TreeNode(start);
		TreeNode n1 = new TreeNode(start - 2 * 2);
		TreeNode n2 = new TreeNode(start - 1 * 2);
		TreeNode n3 = new TreeNode(start - 4 * 2);
		TreeNode n4 = new TreeNode(start - 3 * 2);
		TreeNode n5 = new TreeNode(start - 5 * 2);
		TreeNode n6 = new TreeNode(start + 3 * 2);
		TreeNode n7 = new TreeNode(start + 2 * 2);
		TreeNode n8 = new TreeNode(start + 1 * 2);
		TreeNode n9 = new TreeNode(start + 4 * 2);
		TreeNode n10 = new TreeNode(start + 5 * 2);

		head.Left = n1;
		head.Right = n6;
		n1.Left = n3;
		n1.Right = n2;
		n6.Left = n7;
		n6.Right = n9;
		n3.Left = n5;
		n3.Right = n4;
		n7.Left = n8;
		n9.Right = n10;

		return head;
	}

}
