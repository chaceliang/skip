package edocteel.tree;

import base.TreeNode;

/**
 * Created by chace on 5/3/14.
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftHeight = Integer.MAX_VALUE;
        if (root.left != null) {
            leftHeight = minDepth(root.left);
        }
        int rightHeight = Integer.MAX_VALUE;
        if (root.right != null) {
            rightHeight = minDepth(root.right);
        }
        return Math.min(leftHeight, rightHeight) + 1;
    }
}
