package edocteel.tree;

import base.TreeNode;

public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
        if (root == null) {
        	return true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
        	return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
	
	public int getHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
