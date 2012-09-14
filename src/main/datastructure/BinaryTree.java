package datastructure;

import atom.TreeNode;
import java.util.*;
//Done
//inorder
//preorder
//postorder
//rebuild

//Todo
//compare
//insert
//delete
//deep first
//breadthfirst

public class BinaryTree
{

	public static List<TreeNode> Preorder(TreeNode root)
	{
		System.out.println("Preorder: ");
		List<TreeNode> result = new ArrayList<TreeNode>();
		java.util.Stack<TreeNode> stack = new java.util.Stack<TreeNode>();
		stack.push(root);

		while (stack.size() != 0)
		{
			TreeNode t = stack.peek();

			if (!t.IsVisited)
			{
				System.out.print(t.Data + ",");
				result.add(t);
				t.IsVisited = true;
			}

			if (t.Left != null && !t.Left.IsVisited)
			{
				stack.push(t.Left);
			} else if (t.Right != null && !t.Right.IsVisited)
			{
				stack.push(t.Right);
			} else
				stack.pop();
		}

		System.out.println();
		root.Reset();
		return result;
	}

	public static void Preorder_Recursive(TreeNode node)
	{
		System.out.println("Preorder Recursive: ");
		Preorder_Recursive(node, new ArrayList<TreeNode>());
		System.out.println();
	}

	public static void Preorder_Recursive(TreeNode node, List<TreeNode> result)
	{
		if (node == null)
			return;

		result.add(node);
		System.out.print(node.Data + ",");
		Preorder_Recursive(node.Left, result);
		Preorder_Recursive(node.Right, result);
	}

	public static List<TreeNode> Postorder(TreeNode root)
	{
		System.out.println("Postorder: ");
		List<TreeNode> result = new ArrayList<TreeNode>();
		java.util.Stack<TreeNode> stack = new java.util.Stack<TreeNode>();
		stack.push(root);

		while (stack.size() != 0)
		{
			TreeNode t = stack.peek();

			if (t.Left != null && !t.Left.IsVisited)
			{
				stack.push(t.Left);
			} else if (t.Right != null && !t.Right.IsVisited)
			{
				stack.push(t.Right);
			} else
			{
				System.out.print(t.Data + ",");
				result.add(t);
				t.IsVisited = true;
				stack.pop();
			}
		}

		System.out.println();
		root.Reset();
		return result;
	}

	public static void Postorder_Recursive(TreeNode node)
	{
		System.out.println("Postorder Recursive: ");
		Postorder_Recursive(node, new ArrayList<TreeNode>());
		System.out.println();
	}

	public static void Postorder_Recursive(TreeNode node, List<TreeNode> result)
	{
		if (node == null)
			return;

		Postorder_Recursive(node.Left, result);
		Postorder_Recursive(node.Right, result);
		result.add(node);
		System.out.print(node.Data + ",");
	}

	public static List<TreeNode> Inorder(TreeNode root)
	{
		System.out.println("Inorder: ");
		List<TreeNode> result = new ArrayList<TreeNode>();
		java.util.Stack<TreeNode> stack = new java.util.Stack<TreeNode>();
		stack.push(root);

		while (stack.size() != 0)
		{
			TreeNode t = stack.peek();

			if (t.Left != null && !t.Left.IsVisited)
			{
				stack.push(t.Left);
				t.Left.IsVisited = true;
			} else
			{
				System.out.print(t.Data + ",");
				result.add(t);
				stack.pop();
				if (t.Right != null)
				{
					stack.add(t.Right);
				}
			}
		}

		System.out.println();
		root.Reset();
		return result;
	}

	public static void Inorder_Recursive(TreeNode node)
	{
		System.out.println("Inorder Recursive: ");
		Inorder_Recursive(node, new ArrayList<TreeNode>());
		System.out.println();
	}

	public static void Inorder_Recursive(TreeNode node, List<TreeNode> result)
	{
		if (node == null)
			return;

		Inorder_Recursive(node.Left, result);
		result.add(node);
		System.out.print(node.Data + ",");
		Inorder_Recursive(node.Right, result);
	}

	static Random rand = new Random(System.currentTimeMillis());

	public static TreeNode BuildRandomTree(int size)
	{
		TreeNode b = new TreeNode(rand.nextInt(100));

		List<TreeNode> l = new ArrayList<TreeNode>();
		l.add(b);
		size--;

		while (size > 0)
		{
			int index = rand.nextInt(l.size());
			TreeNode t = l.get(index);
			TreeNode newNode = new TreeNode(rand.nextInt(1000) - 500);
			l.add(newNode);

			if (t.Left == null && t.Right == null)
			{
				if (rand.nextBoolean())
					t.Left = (newNode);
				else
					t.Right = (newNode);
			} else if (t.Left == null)
			{
				t.Left = (newNode);
				l.remove(index);
			} else
			{
				t.Right = (newNode);
				l.remove(index);
			}
			size--;
		}

		return b;
	}

	public static TreeNode BuildTestTree()
	{

		int i = 0;
		TreeNode b = new TreeNode(i++);

		java.util.Queue<TreeNode> l = new java.util.LinkedList<TreeNode>();
		l.add(b);

		while (l.size() > 0)
		{
			TreeNode t = l.poll();

			if (i < 20)
			{
				t.Left = new TreeNode(i++);
				t.Right = new TreeNode(i++);
				l.add(t.Left);
				l.add(t.Right);
			}
		}
		return b;
	}

	public static TreeNode Rebuild(List<TreeNode> inorder, List<TreeNode> preorder)
	{
		TreeNode tn = null;

		if (preorder.size() > 0)
		{
			tn = new TreeNode(preorder.get(0).Data);

			for (int j = 0; j < inorder.size(); j++)
			{
				if (inorder.get(j).Data == tn.Data)
				{
					tn.Left = (Rebuild(inorder.subList(0, j), preorder.subList(1, j + 1)));

					if (inorder.size() - j > 1)
						tn.Right = (Rebuild(inorder.subList(j + 1, inorder.size()),
								preorder.subList(j + 1, preorder.size())));

					break;
				}
			}
		}

		return tn;
	}

	public static TreeNode Rebuild2(List<TreeNode> pre, List<TreeNode> in, int s, int e, int index)
	{
		TreeNode head = null;

		if (index < pre.size() && e >= s)
		{
			head = new TreeNode(pre.get(index).Data);
			for (int i = s; i <= e; i++)
			{
				if (in.get(i).Data == head.Data)
				{
					head.Left = Rebuild2(pre, in, s, i - 1, ++index);
					head.Right = Rebuild2(pre, in, i + 1, e, index + (i - s));
					break;
				}
			}
		}
		return head;

	}

	public static void main(String[] args)
	{
		TreeNode b = BuildTestTree();
		BinaryTree.Postorder(b);

		TreeNode b2 = BinaryTree.Rebuild(BinaryTree.Inorder(b), BinaryTree.Preorder(b));
//		TreeNode b3 = BinaryTree.Rebuild2(BinaryTree.Inorder(b), BinaryTree.Preorder(b), 0,
//				BinaryTree.Preorder(b).size() - 1, 0);

		System.out.println();
		BinaryTree.Postorder(b2);
		BinaryTree.Postorder_Recursive(b2);
		BinaryTree.Inorder(b2);
		BinaryTree.Inorder_Recursive(b2);
		BinaryTree.Preorder(b2);
		BinaryTree.Preorder_Recursive(b2);

	}

}
