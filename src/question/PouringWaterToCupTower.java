package question;

public class PouringWaterToCupTower
{

	/**
	 * http://www.careercup.com/question?id=12770661
	 * Pour water to a cup pyramid 
	 */
	public static void main(String[] args)
	{
		int numOfLayers = 5;
		double totalWater = 20;
		double cupCapacity = 3;
		
		Pour(numOfLayers,cupCapacity,totalWater);
	}
	
	
	
	public static void Pour(int numOfLayers, double cupCapacity, double totalWater )
	{
		double[] cups = GetCups(numOfLayers);
		cups[0] = totalWater;
		
		int index = 0;
		for(int i = 0 ; i < numOfLayers ; i++)
		{
			for(int j = 0 ; j <= i ; j++)
			{				
				int leftChild = index+i+1;
				int rightChild = index+i+2;
				
				if(cups[index] > cupCapacity)
				{
					double overflow = cups[index] - cupCapacity;
					cups[index] = cupCapacity;
					
					if(i != numOfLayers -1)
					{
						cups[leftChild] += overflow/2;					
						cups[rightChild] += overflow/2;
						
						System.out.print(String.format("Left child %d gets %f, Right child %d get %f,",leftChild,cups[leftChild],rightChild,cups[rightChild]));
					}
				}
				
				System.out.println("Cup "+index+" = "+cups[index]);				
				index++;
			}
		}
	}
	
	public static double[] GetCups(int layers)
	{
		return new double[(1+layers)*layers/2];
	}

}
