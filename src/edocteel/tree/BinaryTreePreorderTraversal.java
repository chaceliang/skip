package edocteel.tree;

import base.TreeNode;

import java.util.ArrayList;

/**
 * Created by chace on 5/7/14.
 */
public class BinaryTreePreorderTraversal {

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        preorder(root, result);
        return result;
    }

    public void preorder(TreeNode node, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        preorder(node.left, result);
        preorder(node.right, result);
    }
}
