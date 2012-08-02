package atom;

public class LinkedListNode
{
	public int Data;
	public LinkedListNode Next;
	public LinkedListNode Prev;

	public LinkedListNode()
	{
	}

	public LinkedListNode(int data)
	{
		Data = data;
	}

	public String toString()
	{
		return String.valueOf(Data);
	}
}
