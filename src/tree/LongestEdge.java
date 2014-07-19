package tree;

import base.TreeNode;

/**
 * Created by chace on 6/4/14.
 */
public class LongestEdge {

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int edges(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = height(root);
        return height - 1;
    }
}
