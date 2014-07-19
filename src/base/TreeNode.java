package base;

public class TreeNode {
	
	public int val;
	public TreeNode left;
	public TreeNode right;
    public TreeNode parent;
    public boolean visited;

    public int leftChildrenNumber;
    public int rightChildrenNumber;
	
	public TreeNode(int v) {
		this.val = v;
		this.left = null;
		this.right = null;
        this.parent = null;
        this.leftChildrenNumber = 0;
        this.rightChildrenNumber = 0;
        this.visited = false;
	}

    public String toString() {
        return Integer.toString(val);
    }
}
