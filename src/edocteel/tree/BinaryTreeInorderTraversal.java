package edocteel.tree;

import base.TreeNode;

import java.util.ArrayList;

public class BinaryTreeInorderTraversal {

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    if (root == null) {
	        return result;
	    }
	    helper(root, result);
	    return result;
	}
	
	public void helper(TreeNode node, ArrayList<Integer> result) {
	    if (node == null) {
	        return;
	    }
	    helper(node.left, result);
	    result.add(node.val);
	    helper(node.right, result);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
