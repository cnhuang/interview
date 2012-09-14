package question.amazon;

import java.util.Hashtable;

import search.BFS;

import datastructure.BinaryTree;
import atom.TreeNode;

public class MaxSubtreeSumValue
{

	public static void main(String[] args)
	{
		TreeNode t = BinaryTree.BuildRandomTree(10);
		BFS.BFS_ByLevel(t);
		TreeNode r = FindMaxSubtree(t, new Hashtable<TreeNode, Integer>());
		System.out.println(r.Data);
	}
		
	public static TreeNode FindMaxSubtree(TreeNode node,Hashtable<TreeNode,Integer> sum)
	{
		if(node == null)
			return null;
		
		TreeNode leftMaxNode = FindMaxSubtree(node.Left, sum);
		TreeNode rightMaxNode = FindMaxSubtree(node.Right, sum);
		
		int nodeSum = node.Data + (node.Left == null? 0 : sum.get(node.Left)) 
					  + (node.Right == null? 0 : sum.get(node.Right)) ;		
		sum.put(node, nodeSum);
		
		TreeNode maxNode = node;
		int max = nodeSum;
		
		if(leftMaxNode != null && sum.get(leftMaxNode) > max)
		{
			maxNode = leftMaxNode;
			max = sum.get(leftMaxNode);
		}
		
		if(rightMaxNode != null && sum.get(rightMaxNode) > max)
		{
			maxNode = rightMaxNode;
			max = sum.get(rightMaxNode);
		}		
		
		return maxNode;
	}

}
