package tree;

import base.TreeNode;

import java.util.ArrayList;

/**
 * Created by chace on 6/11/14.
 */
public class FindLongestPath {

    public static int[] longestPath(TreeNode root) {
        if (root == null) {
            throw new NullPointerException();
        }
        int height = getHeight(root);
        int[] results = new int[height];

        longestPathUtil(root, results, 0);

        return results;
    }

    public static void longestPathUtil(TreeNode n, int[] results, int counter) {
        if (n == null) {
            return;
        }
        results[counter++] = n.val;
        if (n.left == null && n.right == null) {
            return;
        }
        longestPathUtil(n.left, results, counter);
        longestPathUtil(n.right, results, counter);
    }

    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
