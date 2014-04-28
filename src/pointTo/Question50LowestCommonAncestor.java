package pointTo;

import base.TreeNode;

public class Question50LowestCommonAncestor {

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
		if (root == null || a == null || b == null) {
			return null;
		}
		
		if (root.value == a.value || root.value == b.value) {
			return root;
		}
		TreeNode l = lowestCommonAncestor(root.left, a, b);
		TreeNode r = lowestCommonAncestor(root.right, a, b);
		
		if (l != null && r != null) {
			return root;
		}
		return l == null ? r : l;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
