package datastructure;

import java.util.ArrayList;
import java.util.List;

public class Stack 
{
	List<Integer> Data = new ArrayList<Integer>();
	int Size;
	
	public Stack(int size)
	{
		Size = size;
	}
	
	public Integer Peek()
	{
		if(Data.size() == 0)
			return null;
		else
			return Data.get(Data.size()-1);
	}
	
	public void Push(int i) throws Exception
	{
		if(Data.size() < Size)
			Data.add(i);
		else 
			throw new Exception("Overflow");
	}
	
	public Integer Pop() 
	{
		if(Data.size() > 0)
			return Data.remove(Data.size()-1);
		else
			return null;
	}
}
