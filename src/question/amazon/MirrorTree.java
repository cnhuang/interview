package question.amazon;

import atom.TreeNode;

public class MirrorTree
{
	/*
	 * http://www.careercup.com/question?id=12627678
	 * 
	 * If two trees are mirrored
	 */

	public static boolean IsMirrored(TreeNode a, TreeNode b)
	{
		if (a == null && b == null)
			return true;
		if (a != null && b != null)
		{
			if (a.Data != b.Data)
				return false;

			return IsMirrored(a.Left, b.Right) && IsMirrored(a.Right, b.Left);

		}
		return false;
	}

}
