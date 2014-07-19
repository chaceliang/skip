package edocteel.tree;

import base.TreeNode;

/**
 * Created by chace on 5/14/14.
 */
public class ConstructBinaryTreeFromPreOrderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode helper(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe || is > ie) {
            return null;
        }
        int rootValue = preorder[ps];
        TreeNode root = new TreeNode(rootValue);
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == rootValue) {
                root.left = helper(preorder, ps+1, ps+i-is, inorder, is, i-1);
                root.right = helper(preorder, ps+i-is+1, pe, inorder, i+1, ie);
            }
        }
        return root;
    }
}
