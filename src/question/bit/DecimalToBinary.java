package question.bit;

public class DecimalToBinary
{

	// Crack code interview p134
	public static void main(String[] args)
	{
		Parse("5.025");
	}
	
	public static void Parse(String s)
	{
		int intPart = Integer.parseInt(s.substring(0,s.indexOf(".")));
		double dPart = Double.parseDouble(s.substring(s.indexOf("."),s.length()));
		
		String intStr = "";
		while(intPart != 0)
		{
			intStr = intPart%2 + intStr;
			intPart /= 2;
		}
		
		String dStr = "";
		
		while(dPart > 0)
		{
			if(dStr.length() > 32)
			{
				System.out.println("Error");
				return;
			}
			
			if(dPart == 1)
			{
				dStr += dPart;
				break;
			}
			
			double r = dPart*2;
			if(r >= 1)
			{
				dStr += "1";
				dPart = r-1;
			}
			else
			{
				dStr += "0";
				dPart = r;
			}			
		}
		
		System.out.println(intStr+"."+dStr);
		
	}

}
