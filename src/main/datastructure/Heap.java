package datastructure;

import java.util.Random;

public class Heap
{

	public static void main(String[] args)
	{
		Random rand = new Random(System.currentTimeMillis());

		int n = 10;
		Heap h = new Heap(n);
		int[] arr = new int[n+1];
		
		for (int i = 0; i < n + 10; i++)
		{
			int t = rand.nextInt(1000) - 500;
			h.Add(t);
			
			if(i < n)
				arr[i+1] = t;
		}
		Heap h2 = new Heap(arr);
		h.Print();
		h2.Print();

		for (int i = 0; i < n + 10; i++)
		{
			System.out.println("["+h.Get()+"]");
			System.out.println("["+h2.Get()+"]");
		}
	}

	int[] _arr;
	int _index = 0;
	int _size;

	public Heap(int size)
	{
		_size = size;
		_arr = new int[_size + 1];
	}
	
	public Heap(int[] arr)
	{
		_size = arr.length-1;
		_arr = arr;
		_index = _size;
		Heapify();
	}
	
	public void Heapify()
	{
		for(int i = 2 ; i <= _index ; i++)
		{
			Poll(i);
		}
	}
	
	public int Get()
	{
		if (_index >= 1)
		{
			int data = _arr[1];
			
			_arr[1] = _arr[_index--];
			Push(1);
			
			return data;		
		}
		
		return Integer.MIN_VALUE;
	}

	public void Push(int c)
	{		
		if (c > _index)
			return;
		//System.out.println("Push "+c);
		int l = c * 2;
		int r = c * 2 + 1;

		int min = _arr[c];
		int minIndex = c;

		if (l <= _index && _arr[l] < min)
		{
			min = _arr[l];
			minIndex = l;
		}
		else
			return;

		if (r <= _index && _arr[r] < min)
		{
			min = _arr[r];
			minIndex = r;
		}

		if (minIndex != c)
		{
			min = _arr[c];
			_arr[c] = _arr[minIndex];
			_arr[minIndex] = min;

			Push(minIndex);
		}

	}

	public void Add(int n)
	{
		if (_index < _size)
		{
			_arr[++_index] = n;
			Poll(_index);
		}
	}

	private void Poll(int current)
	{
		if(current <= 1)
			return;
		
		//System.out.println("Poll "+current);
		
		int parent = current / 2;

		if (_arr[parent] > _arr[current])
		{
			Integer tmp = _arr[current];
			_arr[current] = _arr[parent];
			_arr[parent] = tmp;

			Poll(parent);
		}

	}
		
	private void Print()
	{
		for(int i = 1 ; i <= _index ; i++)
		{
			System.out.print(_arr[i]+",");
		}
		
		System.out.println();
	}

}
