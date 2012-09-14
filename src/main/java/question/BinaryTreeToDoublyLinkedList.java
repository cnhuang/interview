package question;


import atom.*;
import datastructure.*;

public class BinaryTreeToDoublyLinkedList
{

	public static void main(String[] args)
	{
		TreeNode t = BinaryTree.BuildTestTree();
		BinaryTree.Inorder(t);
		TreeNode r = Convert(t);
		
		System.out.print(r.Data+" ");
		while(r.Right != null)
		{
			r = r.Right;
			System.out.print(r.Data+" ");
		}
		System.out.println();
		
		System.out.print(r.Data+" ");
		while(r.Left != null)
		{
			r = r.Left;
			System.out.print(r.Data+" ");
		}
	}

	public static TreeNode Convert(TreeNode t)
	{
		TreeNode head = null;
		TreeNode prev = null;

		java.util.Stack<TreeNode> stack = new java.util.Stack<TreeNode>();
		stack.push(t);

		while (!stack.isEmpty())
		{
			t = stack.peek();

			if (t.Left != null && !t.Left.IsVisited)
			{
				stack.push(t.Left);
				continue;
			}

			if (prev == null)
			{
				head = t;
			} else
			{
				prev.Right = t;
			}

			t.Left = prev;
			prev = t;
			stack.pop();
			t.IsVisited = true;
			
			if (t.Right != null && !t.Right.IsVisited)
			{
				stack.push(t.Right);
			}

		}

		prev.Right = null;
		return head;
	}

}
