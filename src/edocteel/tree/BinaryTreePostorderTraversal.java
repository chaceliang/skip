package edocteel.tree;

import base.TreeNode;

import java.util.ArrayList;

/**
 * Created by chace on 5/7/14.
 */
public class BinaryTreePostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        postorder(root, result);
        return result;
    }

    public void postorder(TreeNode node, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.val);
    }
}
