package pointTo;

import base.TreeNode;

public class Question18DoesTree1HasTree2 {
	
	public static boolean doesTree1HasTree2(TreeNode node1, TreeNode node2) {
		if (node2 == null) {
			return true;
		}
		if (node1 == null) {
			return false;
		}
		if (node1.val != node2.val) {
			return false;
		}
		return doesTree1HasTree2(node1.left, node2.left) && doesTree1HasTree2(node1.right, node2.right);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
