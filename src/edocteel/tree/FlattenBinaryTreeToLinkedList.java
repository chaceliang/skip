package edocteel.tree;

import base.TreeNode;

/**
 * Created by chace on 5/4/14.
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            TreeNode rightMost = findRightMost(root.left);
            TreeNode rightChild = root.right;
            root.right = root.left;
            root.left = null;
            rightMost.right = rightChild;
        }
        flatten(root.right);
    }

    public TreeNode findRightMost(TreeNode node) {
        if (node == null || node.right == null) {
            return node;
        }
        return findRightMost(node.right);
    }

}
