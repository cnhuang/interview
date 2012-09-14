package question.amazon;

import java.util.HashMap;

public class CloneLinkedList
{

	//http://www.careercup.com/question?id=12590664
	//You are given a linked list. Apart from the normal "Next" pointer, 
	//there is one more pointer(random ptr) in each node which points to some random node of the list. 
	//How will you create a clone of such a list? 

	public static void main(String[] args)
	{
		
	}
	
	public static LinkedListNode Clone(LinkedListNode head)
	{
		if(head == null)
			return null;
		HashMap<LinkedListNode,LinkedListNode> map = new HashMap<LinkedListNode,LinkedListNode>();
		LinkedListNode tmp = head;
		
		LinkedListNode n = new LinkedListNode(tmp.Data);	
		map.put(tmp, n);
		
		while(tmp.Next != null)
		{			
			n = new LinkedListNode(tmp.Next.Data);
			map.put(tmp.Next, n);
			map.get(tmp).Next = map.get(tmp.Next);	
			tmp = tmp.Next;
		}
		
		tmp = head;
		
		while(tmp != null)
		{						
			map.get(tmp).Random = map.get(tmp.Random);		
			tmp = tmp.Next;
		}
		
		return map.get(head);
	}

}

class LinkedListNode
{
	LinkedListNode Next;
	LinkedListNode Random;
	int Data;
	
	public LinkedListNode(int i)
	{
		Data = i; 
	}
}
