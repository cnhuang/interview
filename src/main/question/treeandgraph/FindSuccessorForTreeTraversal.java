package question.treeandgraph;

import java.util.List;

import atom.TreeNode;
import datastructure.BinaryTree;

public class FindSuccessorForTreeTraversal
{
	// Crack code interview p127
	public static void main(String[] args)
	{
		TreeNode t = BinaryTree.BuildTestTree();
		t.SetParentToAll(null);
		List<TreeNode> l = BinaryTree.Inorder(t);
		for (TreeNode tn : l)
			System.out.println(tn + "->" + FindInOrderSucceesor(tn));

		l = BinaryTree.Preorder(t);
		for (TreeNode tn : l)
			System.out.println(tn + "->" + FindPreOrderSucceesor(tn));

		l = BinaryTree.Postorder(t);
		for (TreeNode tn : l)
			System.out.println(tn + "->" + FindPostOrderSucceesor(tn));

	}

	public static TreeNode FindInOrderSucceesor(TreeNode t)
	{
		if (t.Right != null)
		{
			TreeNode n = t.Right;

			while (n.Left != null)
				n = n.Left;

			return n;
		}
		else
		{
			TreeNode p = t.Parent;

			while (p != null)
			{
				if (p.Left == t)
					return p;

				t = p;
				p = t.Parent;
			}

			return p;
		}

	}

	public static TreeNode FindPreOrderSucceesor(TreeNode t)
	{
		if (t.Left != null)
			return t.Left;
		else if (t.Right != null)
			return t.Right;
		else
		{
			TreeNode p = t.Parent;

			while (p != null)
			{
				if (p.Left == t && p.Right != null)
					return p.Right;

				t = p;
				p = t.Parent;
			}
			return p;
		}
	}

	public static TreeNode FindPostOrderSucceesor(TreeNode t)
	{
		TreeNode p = t.Parent;

		if (p != null)
		{
			if (p.Right == t || p.Right == null)
				return p;
			else
			{
				return FindPostOrderSucceesor_Helper(p.Right);
			}
		}
		return p;
	}
	
	public static TreeNode FindPostOrderSucceesor_Helper(TreeNode t)
	{
		if(t.Left == null && t.Right == null)
			return t;
		else if(t.Left != null)
			return FindPostOrderSucceesor_Helper(t.Left);
		else 
			return FindPostOrderSucceesor_Helper(t.Right);
	}

}
