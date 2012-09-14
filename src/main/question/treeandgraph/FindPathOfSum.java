package question.treeandgraph;

import java.util.ArrayList;
import java.util.List;

import datastructure.BinaryTree;
import atom.TreeNode;

public class FindPathOfSum
{
	//Crack code interview p33
	public static void main(String[] args)
	{
		TreeNode t = BinaryTree.BuildRandomTree(500);
		Find(t,new ArrayList<Integer>(),20);
	}
	
	public static void Find(TreeNode t, List<Integer> buffer, int sum)
	{
		if(t == null)
			return;
		else
			buffer.add(t.Data);
		
		int tmp = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = buffer.size()-1 ; i >=0 ; i--)
		{
			tmp += buffer.get(i);
			sb.append(buffer.get(i)).append(",");
			if(tmp == sum)
			{
				System.out.println(sb.toString());
			}
		}
		
		Find(t.Left,buffer,sum);
		Find(t.Right,buffer,sum);
		buffer.remove(buffer.size()-1);
		
	}

}
