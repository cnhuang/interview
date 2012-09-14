package stringmatch;

public class KMP
{
	public static void main(String[] args)
	{
		String strSource = "ABC ABCDABAABCDABCDABDE";
		String strTarget = "ABCDABD";
		System.out.println(Match(strTarget,strSource));
	}

	public static int Match(String target, String source)
	{
		int tIndex = 0;
		int sourceIndex = 0;
		int nextStart = -1;

		while (sourceIndex < source.length())
		{
			if (nextStart == -1 && tIndex != 0 && source.charAt(sourceIndex) == target.charAt(0))
			{
				nextStart = sourceIndex;
				// Log.Comment(String.Format("New Start: Source {0}",
				// nextStart));
			}

			if (source.charAt(sourceIndex) == target.charAt(tIndex))
			{
				// Log.Comment(String.Format("Match: Target {0} Source {1}",
				// tIndex,sourceIndex));

				if (tIndex == target.length() - 1)
				{
					// Log.Comment(String.Format("Found: Target {0} Source {1}",
					// tIndex, sourceIndex));
					return sourceIndex - target.length() + 1;
				}

				tIndex++;
				sourceIndex++;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
			} else
			{
				// Log.Comment(String.Format("Mismatch: Target {0} Source {1}",
				// tIndex, sourceIndex));

				tIndex = 0;
				if (nextStart == -1)
				{
					sourceIndex++;
				} else
				{
					sourceIndex = nextStart;
					nextStart = -1;
				}

				System.out.println(String.format("New Index: Target %d Source %d NewStart %d",
						tIndex, sourceIndex, nextStart));

			}
		}
		;

		return -1;

	}
}
