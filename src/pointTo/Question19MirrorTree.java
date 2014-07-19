package pointTo;

import base.TreeNode;

public class Question19MirrorTree {
	
	public static void mirror(TreeNode node) {
		if (node == null || (node.left == null && node.right == null)) {
			return;
		}
		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;
		if (node.left != null) {
			mirror(node.left);
		}
		if (node.right != null) {
			mirror(node.right);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
