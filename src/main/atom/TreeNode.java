package atom;

public class TreeNode
{
	public int Data;
	public TreeNode Link;
	public TreeNode Sibling;
	public TreeNode Parent;
	public TreeNode Left;
	public TreeNode Right;
	public boolean IsVisited = false;

	public TreeNode(int data)
	{
		Data = data;
	}

	public TreeNode()
	{

	}
	
	public void Reset()
	{
		this.IsVisited = false;
		if(null != Left)
			this.Left.Reset();
		if(null != Right)
			this.Right.Reset();
	}
	
	public void SetParentToAll(TreeNode t)
	{
		this.Parent = t;
		if(this.Left != null)
			this.Left.SetParentToAll(this);
		if(this.Right != null)
			this.Right.SetParentToAll(this);
	}

}
