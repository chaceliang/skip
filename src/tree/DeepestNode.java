package tree;

import base.TreeNode;

/**
 * Created by chace on 6/7/14.
 */

public class DeepestNode {

    static int maxLevel = 0;
    static TreeNode result = null;

    public static TreeNode deepestLeftLeaf(TreeNode root) {
        deepestLeafUtil(root, 0, false);
        return result;
    }

    public static void deepestLeafUtil(TreeNode x, int level, boolean isLeft) {
        if (x == null) {
            return;
        }
        if (isLeft && x.left == null && x.right == null && level > maxLevel) {
            result = x;
            maxLevel = level;
            return;
        }

        deepestLeafUtil(x.left, level + 1, true);
        deepestLeafUtil(x.right, level + 1, false);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println(deepestLeftLeaf(root).val);
    }
}
