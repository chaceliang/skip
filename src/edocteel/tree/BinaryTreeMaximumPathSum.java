package edocteel.tree;

import base.TreeNode;

/**
 * Created by chace on 5/3/14.
 */
public class BinaryTreeMaximumPathSum {
    static int maxSoFar = 0;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxSoFar = root.val;
        helper(root);
        return maxSoFar;
    }

    public int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMax = helper(node.left);
        int rightMax = helper(node.right);
        int maxPath = node.val;
        if (leftMax > 0) {
            maxPath += leftMax;
        }
        if (rightMax > 0) {
            maxPath += rightMax;
        }
        if (maxPath > maxSoFar) {
            maxSoFar = maxPath;
        }
        int result = node.val;
        return Math.max(result, result + Math.max(leftMax, rightMax));
    }
}
