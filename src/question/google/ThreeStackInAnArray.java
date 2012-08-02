package question.google;

import java.util.Random;
import org.junit.Test;

public class ThreeStackInAnArray
{
	@Test
	public void Test()
	{
		Random rand = new Random(System.currentTimeMillis());
		ArrayStack stack = new ArrayStack(20);

		for (int i = 0; i < 2000; i++)
		{
			int index = rand.nextInt(3) + 1;
			int action = rand.nextInt(3);
			int data = rand.nextInt(100);

			switch (action)
			{
			case 0:
				System.out.println("Stack " + index + " Push " + data);
				stack.Push(index, data);
				break;
			case 1:
				data = stack.Peek(index);
				System.out.println("Stack " + index + " Peek " + data);
				break;
			case 2:
				data = stack.Pop(index);
				System.out.println("Stack " + index + " Pop " + data);
				break;
			default:
				break;
			}

			System.out.println(stack);
		}
	}
}

class ArrayStack
{
	StackObject[] Data;
	int[] stackIndex;
	int dataIndex;

	public ArrayStack(int size)
	{
		Data = new StackObject[size];
		stackIndex = new int[4];
		for (int i = 0; i < 4; i++)
			stackIndex[i] = -1;

		dataIndex = 0;
	}

	public void Push(int index, int data)
	{
		if (dataIndex == Data.length && stackIndex[0] == -1)
		{
			System.out.println("Full");
		} else
		{
			int tail = stackIndex[index];
			StackObject so = null;

			if (tail == -1)
			{
				so = new StackObject(data);
			} else
			{
				so = new StackObject(data, tail);
			}

			if (dataIndex < Data.length)
			{
				Data[dataIndex] = so;
				stackIndex[index]=  dataIndex++;
				//SetTail(index, dataIndex++);
			} else
			{
				int preFree = Data[stackIndex[0]].GetPreviousIndex();
				Data[stackIndex[0]] = so;
				stackIndex[index] = stackIndex[0];
				stackIndex[0] = preFree;
			}
		}

	}

	public int Peek(int index)
	{
		int tail = stackIndex[index];

		if (tail == -1)
		{
			System.out.println("Stack[" + index + "] is empty");
			return -1;
		} else
		{
			return Data[tail].GetData();
		}

	}

	public int Pop(int index)
	{
		int tail = stackIndex[index];

		if (tail == -1)
		{
			System.out.println("Stack[" + index + "] is empty");
			return -1;
		} else
		{
			int preTail = Data[tail].GetPreviousIndex();
			Data[tail].SetPreviousIndex(stackIndex[0]);
			stackIndex[0] = tail;
			stackIndex[index] = preTail;
			//SetTail(index, preTail);
			return Data[tail].GetData();
		}
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("\n");

		for (int i = 0; i <= 3; i++)
		{
			sb.append("[Stack ").append(i).append("] ");
			int tail = stackIndex[i];

			while (tail != -1)
			{
				sb.append(tail).append("-").append(Data[tail]).append(" ");
				tail = Data[tail].GetPreviousIndex();
			}

			sb.append("\n");
		}

		sb.append("\n\n");

		return sb.toString();
	}
}

class StackObject
{
	int preIndex = -1;
	int data;

	public StackObject(int data)
	{
		preIndex = -1;
		this.data = data;
	}

	public StackObject(int data, int preIndex)
	{
		this.preIndex = preIndex;
		this.data = data;
	}

	public int GetData()
	{
		return data;
	}

	public int GetPreviousIndex()
	{
		return preIndex;
	}

	public void SetPreviousIndex(int index)
	{
		preIndex = index;
	}

	public String toString()
	{
		return "(" + preIndex + ":" + data + ")";
	}
}