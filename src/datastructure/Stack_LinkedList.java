package datastructure;

import atom.LinkedListNode;

public class Stack_LinkedList
{
	LinkedListNode top;
	
	public Stack_LinkedList()
	{
		
	}
	
	public void Push(int i)
	{
		LinkedListNode n = new LinkedListNode(i);
		n.Next = top;
		top = n;
	}
	
	public int Pop()
	{
		if(top != null)
		{
			int data = top.Data;
			top = top.Next;
			return data;
		}
		
		return Integer.MIN_VALUE;
	}
}
