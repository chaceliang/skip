package edocteel.tree;

import base.TreeNode;

/**
 * Created by chace on 5/4/14.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean validate(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.val > min && node.val < max) {
            return validate(node.left, min, node.val) && validate(node.right, node.val, max);
        }
        return false;
    }
}
