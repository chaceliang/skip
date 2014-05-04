package pointTo;

import java.util.LinkedList;
import java.util.Queue;

import base.TreeNode;

public class Question23PrintTreeByLevel {

	public static void printTreeByLevel(TreeNode node) {
		if (node == null) {
			return;
		}
		Queue<TreeNode> container = new LinkedList<TreeNode>();
		container.add(node);
		while (!container.isEmpty()) {
			int size = container.size();
			for (int i = 0; i < size; i++) {
				TreeNode n = container.poll();
				System.out.print(n.val + " ");
				if (n.left != null) {
					container.add(n.left);
				}
				if (n.right != null) {
					container.add(n.right);
				}
			}
			System.out.println();	
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
