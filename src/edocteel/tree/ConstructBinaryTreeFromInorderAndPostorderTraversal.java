package edocteel.tree;

import base.TreeNode;

/**
 * Created by chace on 5/5/14.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (is > ie || ps > pe) {
            return null;
        }
        int rootValue = postorder[pe];
        TreeNode root = new TreeNode(rootValue);
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == rootValue) {
                root.left = helper(inorder, is, i-1, postorder, ps, ps+i-is-1);
                root.right = helper(inorder, i+1, ie, postorder, pe-(ie-i), pe-1);
            }
        }
        return root;
    }
}
