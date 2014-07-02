package base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeUtils {

	public static void printTreeByLevel(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return;
        }
        Queue<TreeNode> tmp = new LinkedList<TreeNode>();
        tmp.add(root);
        while (!tmp.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = tmp.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = tmp.poll();
                level.add(node.val);
                if (node.left != null) {
                    tmp.add(node.left);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                }
            }
            result.add(level);
        }
        for (ArrayList<Integer> al : result) {
            System.out.println(al);
        }
        return;
	}
	
	public static void printTreeInorder(TreeNode node) {
		if (node == null) {
			return;
		}
		printTreeInorder(node.left);
		System.out.print(node.val + " ");
		printTreeInorder(node.right);
	}

    public static boolean isBSTNode(TreeNode node) {
        if (node == null) {
            return true;
        }
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        if (node.left != null) {
            left = node.left.val;
        }
        if (node.right != null) {
            right = node.right.val;
        }
        return node.val > left && node.val < right;
    }

    public static void swapNode(TreeNode n1, TreeNode n2) {
        TreeNode tmp = n1;
        n1 = n2;
        n2 = tmp;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
