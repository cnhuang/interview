package question;

import java.util.*;
import atom.TreeNode;
import org.junit.Test;

public class LinkSiblings
{
	/*
	 * Given a tree, link nodes to their right siblings
	 */

	public void Link(TreeNode n)
	{
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();

		q1.add(n);

		while (true)
		{
			while (!q1.isEmpty())
			{
				TreeNode n2 = q1.poll();
				if (n2.Left != null)
					q2.add(n2.Left);
				if (n2.Right != null)
					q2.add(n2.Right);
			}

			while (!q2.isEmpty())
			{
				TreeNode n2 = q2.poll();
				if (!q2.isEmpty())
				{
					n2.Sibling = (q2.peek());
					System.out
							.print(String.format("Node(%d) -> Node(%d),", n2.Data, q2.peek().Data));
				}
				q1.add(n2);
			}

			System.out.println();
			if (q1.isEmpty())
				return;
		}
	}

	@Test
	public void LinkTest()
	{
		TreeNode node = BuildTestTree();
		Link(node);
	}

	public TreeNode BuildTestTree()
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
				t.Left = (new TreeNode(i++));
				t.Right = (new TreeNode(i++));
				l.add(t.Left);
				l.add(t.Right);
			}
		}
		return b;
	}

}
