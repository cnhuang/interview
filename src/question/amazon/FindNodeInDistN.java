package question.amazon;

import java.util.*;

import search.BFS;

import datastructure.BinaryTree;
import atom.TreeNode;

public class FindNodeInDistN
{

	// http://www.careercup.com/question?id=12672672
	// FInd all nodes which are of distance K from a given node.

	public static void main(String[] args)
	{
		TreeNode n = BinaryTree.BuildTestTree();
		List<TreeNode> ns = BinaryTree.Inorder(n);
		BFS.BFS_ByLevel(n);

		for (TreeNode t : ns)
		{
			System.out.println("Find " + t.Data);
			M1_FindN(n, t, 3);
			n.Reset();
			System.out.println();
			M2_Recursive(n, t, 3);
			n.Reset();
			System.out.println();
		}
	}

	public static void M1_FindN(TreeNode head, TreeNode n, int d)
	{
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = head;
		stack.add(node);
		boolean find = false;

		while (stack.size() != 0)
		{
			if (find)
			{
				if (d < 0)
					return;

				node = stack.pop();
				if (d == 0)
					System.out.print(node.Data + ",");
				else
				{
					FindChildInDistance(node.Left, d - 1);
					FindChildInDistance(node.Right, d - 1);
				}
				d--;
			}
			else
			{
				node = stack.peek();
				node.IsVisited = true;

				if (n.Data == node.Data)
				{
					find = true;
					if (d == 0)
						System.out.print(node.Data + ",");
					else
					{
						FindChildInDistance(node.Left, d - 1);
						FindChildInDistance(node.Right, d - 1);
					}
					d--;
					stack.pop();
				}
				else
				{
					if (node.Left != null && !node.Left.IsVisited)
						stack.add(node.Left);
					else if (node.Right != null
							&& !node.Right.IsVisited)
						stack.add(node.Right);
					else
						stack.pop();
				}
			}
		}
	}

	public static int M2_Recursive(TreeNode node, TreeNode target, int d)
	{
		if (node == null)
			return Integer.MAX_VALUE;
		if (node.IsVisited)
			return Integer.MAX_VALUE;

		if (node == target)
		{
			node.IsVisited = true;
			FindChildInDistance(node.Left, d - 1);
			FindChildInDistance(node.Right, d - 1);
			return d - 1;
		}
		else
		{
			int c = Math.min(M2_Recursive(node.Left, target, d),
					M2_Recursive(node.Right, target, d));
			if (c == 0)
			{
				node.IsVisited = true;
				System.out.print(node.Data + ",");
				return Integer.MAX_VALUE;
			}
			else if (c > 0 && c <= d)
			{
				node.IsVisited = true;
				FindChildInDistance(node.Left, c - 1);
				FindChildInDistance(node.Right, c - 1);
				return c - 1;
			}
			else
				return Integer.MAX_VALUE;
		}
	}

	public static void FindChildInDistance(TreeNode node, int d)
	{
		if (node == null)
			return;
		if (d < 0)
			return;
		if (d == 0)
			System.out.print(node.Data + ",");
		else
		{
			FindChildInDistance(node.Left, d - 1);
			FindChildInDistance(node.Right, d - 1);
		}
	}
}
