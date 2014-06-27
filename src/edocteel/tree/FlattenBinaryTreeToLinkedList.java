package edocteel.tree;

import base.TreeNode;

/**
 * Created by chace on 5/4/14.
 */
public class FlattenBinaryTreeToLinkedList {
    /*
    Given a binary tree, flatten it to a linked list in-place.

    For example,
    Given

             1
            / \
           2   5
          / \   \
         3   4   6
    The flattened tree should look like:
       1
        \
         2
          \
           3
            \
             4
              \
               5
                \
                 6

     */
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
        if (node == null) {
            return node;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

}
