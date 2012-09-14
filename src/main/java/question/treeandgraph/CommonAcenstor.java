package question.treeandgraph;

import java.util.List;

import datastructure.BinaryTree;
import atom.TreeNode;

public class CommonAcenstor
{

	// Crack code interview p128
	static TreeNode result = null;
	public static void main(String[] args)
	{
		TreeNode t = BinaryTree.BuildTestTree();
		t.SetParentToAll(null);

		List<TreeNode> l = BinaryTree.Inorder(t);
		for (TreeNode tn : l)
		{
			for (TreeNode tn2 : l)
			{
				if (tn != tn2)
				{
					result = null;
					Find1(t, tn, tn2);
					System.out.println(tn + "," + tn2 + " -> " + result);
				}
			}
		}
	}

	public static int Find1(TreeNode n, TreeNode a, TreeNode b)
	{
		if (result != null)
			return 0;
		else if (n == null)
			return 0;
		else
		{
			int c = 0;
			if (n == a || n == b)
				c = 1;

			c += Find1(n.Left, a, b)
					+ Find1(n.Right, a, b);
			if (c == 2 && result == null)
				result = n;

			return c;
		}
	}
}
