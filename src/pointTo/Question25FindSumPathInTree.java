package pointTo;

import java.util.LinkedList;

import base.TreeNode;

public class Question25FindSumPathInTree {
	
	public static void findPath(TreeNode node, int expectedSum) {
		if (node == null) {
			return;
		}
		LinkedList<TreeNode> path = new LinkedList<TreeNode>();
		int currentSum = 0;
		findPath(node, path, expectedSum, currentSum);
	}
	
	public static void findPath(TreeNode node, LinkedList<TreeNode> path, int expectedSum, int currentSum) {
		currentSum += node.value;
		path.add(node);
		boolean isLeaf = node.left == null && node.right == null;
		if (currentSum == expectedSum && isLeaf) {
			System.out.println("Found!");
		}
		if (node.left != null) {
			findPath(node.left, path, expectedSum, currentSum);
		}
		if (node.right != null) {
			findPath(node.right, path, expectedSum, currentSum);
		}
		currentSum -= node.value;
		path.removeLast();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
