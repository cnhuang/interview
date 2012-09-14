package test;

public class AssertionAndDebug
{

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args)
	{
		//Assertion are disabled at run-time during execution of java program .
		//The command line prompt  -ea or enable assertions is used to enable assertion during run-time execution of the program.
		//java -ea:AssertDemonstration

		int maximummarks = 100;
		assert maximummarks >= 40.00 : "marks is below 40.";

	}

}
