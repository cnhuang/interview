package question.google;

import java.util.*;

import search.BFS;

import atom.TreeNode;

public class FindSmallerNumsOnRight
{

	// http://www.careercup.com/question?id=12814662
	// eg : [4,12,5,6,1,34,3,2]
	// o/p [3,5,3,3,0,2,1,0]

	public static void main(String[] args)
	{
		SortAndFind(new int[]
		{ 4, 12, 5, 6, 1, 34, 3, 2 });
	}

	public static void SortAndFind(int[] input)
	{
		int[] order = new int[input.length];
		for (int i = 0; i < input.length; i++)
			order[i] = i;

		QuickSort(input, order, 0, input.length - 1);
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(order));

	}

	private static void QuickSort(int[] input, int[] order, int s, int e)
	{

		if (e <= s)
			return;

		int pivot = input[(s + e) / 2];
		int i = s;
		int j = e;

		while (i <= j)
		{
			while (input[i] < pivot)
				i++;

			while (input[j] > pivot)
				j--;

			if (j >= i)
			{
				int tmp = input[j];
				input[j] = input[i];
				input[i] = tmp;

				tmp = order[j];
				order[j] = order[i];
				order[i] = tmp;

				j--;
				i++;
			}
		}

		// System.out.println(String.format("%d %d %d %d %d %s", pivot, s
		// ,e,i,j, Arrays.toString(input)));

		QuickSort(input, order, s, j);
		QuickSort(input, order, i, e);

	}

	// Does not work
	public static void BST(int[] input)
	{
		Hashtable<TreeNode, Integer> childCount = new Hashtable<TreeNode, Integer>();
		List<TreeNode> tmp = new ArrayList<TreeNode>();

		TreeNode root = new TreeNode(input[0]);
		childCount.put(root, 0);
		tmp.add(root);

		for (int i = 1; i < input.length; i++)
		{
			tmp.add(BuildTree(root, input[i], childCount));
		}

		BFS.BFS_ByLevel(root);

		for (TreeNode node : tmp)
		{
			if (node.Left == null)
				System.out.print("0 ");
			else
				System.out.print(childCount.get(node.Left) + " ");
		}
		System.out.println();
	}

	public static TreeNode BuildTree(TreeNode root, int data,
			Hashtable<TreeNode, Integer> count)
	{
		TreeNode node = new TreeNode(data);
		TreeNode tmp = root;

		while (true)
		{
			count.put(tmp, count.get(tmp) + 1);

			if (tmp.Data > data)
			{
				if (tmp.Left == null)
				{
					tmp.Left = node;
					count.put(node, 0);
					break;
				}
				else if (data > tmp.Left.Data)
				{
					node.Left = tmp.Left;
					tmp.Left = node;
					count.put(node, count.get(node.Left) + 1);
					break;
				}
				else
				{
					tmp = tmp.Left;
				}
			}
			else
			{
				if (tmp.Right == null)
				{
					tmp.Right = node;
					count.put(node, 0);
					break;
				}
				else if (data < tmp.Right.Data)
				{
					node.Right = tmp.Right;
					tmp.Right = node;
					count.put(node, count.get(node.Right) + 1);
					break;
				}
				else
					tmp = tmp.Right;
			}
		}
		return node;
	}

}
