package pointTo;

import base.TreeNode;

public class Question39DetphOfTree {

	public static int depthOfTree(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = depthOfTree(node.left);
		int right = depthOfTree(node.right);
		return left > right ? left + 1 : right + 1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
