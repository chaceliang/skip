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
	
	public static boolean isBalance1(TreeNode node) {
		if (node == null) {
			return true;
		}
		int diff = Math.abs(depthOfTree(node.left) - depthOfTree(node.right));
		if (diff > 1) {
			return false;
		}
		return isBalance1(node.left) && isBalance1(node.right);
	}
	
	public static boolean isBalance2(TreeNode node, Depth depth) {
		if (node == null) {
			depth.value = 0;
			return true;
		}
		Depth left = new Depth(0);
		Depth right = new Depth(0);
		if (isBalance2(node.left, left) && isBalance2(node.right, right)) {
			int diff = left.value - right.value;
			if (diff == 1 || diff == -1) {
				depth.value = 1 + (left.value > right.value ? left.value : right.value);
				return true;
			}
		}
		return false;
	}
	
	public static boolean isBalance2(TreeNode node) {
		Depth depth = new Depth(0);
		return isBalance2(node, depth);
	}
	
	public static void test(Depth d) {
		d.value = 99;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}

class Depth {
	int value;
	
	public Depth(int v) {
		this.value = v;
	}
}
