package datastructure;

import java.util.*;

//build heap: n
//heapify: logn
public class HeapGeneric<T>
{
	Object[] _arr;
	int _index = 0;
	Comparator<T> _c;

	public HeapGeneric(int[] arr, Comparator<T> c)
	{
		this(arr.length, c);

		_index = arr.length;
		for (int i = 0; i < arr.length; i++)
			_arr[i + 1] = arr[i];

		Build();

	}

	public HeapGeneric(int size, Comparator<T> c)
	{
		_arr = new Object[size + 1];
		_c = c;
	}

	public HeapGeneric(List<T> list, Comparator<T> c)
	{
		this(list.size(), c);
		for (int i = 0; i < list.size(); i++)
			_arr[i + 1] = list.get(i);

		_index = list.size();
		Build();
	}

	public void Insert(T obj) throws Exception
	{
		if (_index == (_arr.length - 1))
			throw new Exception("Out Of Boundary");

		_arr[++_index] = obj;
		PushUp(_index);
	}

	private void PushUp(int i)
	{
		int cIndex = i;
		int pIndex = cIndex / 2;

		while (pIndex > 0 && _c.compare(get(pIndex), get(cIndex)) < 0)
		{
			Swap(pIndex, cIndex);
			cIndex = pIndex;
			pIndex = cIndex / 2;
		}
	}

	public void RemoveTop() throws Exception
	{
		if (_index < 1)
			throw new Exception("Out Of Boundary");

		Swap(_index, 1);
		_arr[_index--] = null;
		Heapify(1);
	}

	public void Sort()
	{
		int tmp = _index;
		for (int i = _index; i > 1; i--)
		{
			Swap(1, i);
			_index--;
			Heapify(1);
		}
		_index = tmp;
	}

	public void Test(String text)
	{
		for (int i = 1; i <= _index / 2; i++)
		{
			if ((null != this.get(2 * i) && _c.compare(this.get(i),
					this.get(2 * i)) < 0)
					|| (this.get(2 * i + 1) != null && _c.compare(this.get(i),
							this.get(2 * i + 1)) < 0))
			{
				System.out.println(text + " Error");
				System.out.println(this);
				return;
			}
		}
		System.out.println(text + " Success");
		System.out.println(this);
	}

	private void Build()
	{
		for (int i = _index / 2; i > 0; i--)
			Heapify(i);
	}

	public void Heapify(int i)
	{

		if (i > 0 && i <= _index)
		{

			T l = this.get(i * 2);
			T r = this.get(i * 2 + 1);
			int largest = i;

			if (l != null && _c.compare(this.get(largest), l) < 0)
				largest = i * 2;
			if (r != null && _c.compare(this.get(largest), r) < 0)
				largest = i * 2 + 1;

			if (i != largest)
			{
				Swap(i, largest);
				Heapify(largest);
			}
		}
	}

	private void Swap(int i, int j)
	{
		T tmp = this.get(j);
		_arr[j] = this.get(i);
		_arr[i] = tmp;
	}

	@SuppressWarnings(
	{ "unchecked" })
	T get(int i)
	{
		if (i <= _index)
			return (T) _arr[i];
		return null;
	}

	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < _index; i++)
		{
			sb.append(_arr[i + 1].toString()).append(",");
		}

		return sb.toString();
	}

	public static void main(String[] args) throws Exception
	{
		int[] arr =
		{ 5, 9, 6, 25, 4, 1, 2, 6, 7 };
		Comparator<Integer> c = new Comparator<Integer>()
		{
			@Override
			public int compare(Integer o1, Integer o2)
			{

				return o1 <= o2 ? 1 : -1;
			}
		};

		HeapGeneric<Integer> heap = new HeapGeneric<Integer>(arr, c);
		heap.Test("Build");
		heap.RemoveTop();
		heap.Test("Remove");
		heap.Insert(new Integer(50));
		heap.Test("Insert 50");
		heap.RemoveTop();
		heap.Test("Remove");
		heap.Insert(new Integer(0));
		heap.Test("Insert 0");
		heap.Sort();
		System.out.println(heap);

	}
}
