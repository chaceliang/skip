package tree;

import base.TreeNode;

/**
 * Created by chace on 5/21/14.
 */
public class MirrorTree {

    public void mirror(TreeNode n) {
        if (n == null) return;

        mirror(n.left);
        mirror(n.right);

        TreeNode tmp = n.left;
        n.left = n.right;
        n.right = tmp;
    }

    public void mirror2(TreeNode n) {
        if (n == null || n.left == null || n.right == null) {
            return;
        }

        TreeNode tmp = n.left;
        n.left = n.right;
        n.right = tmp;

        mirror2(n.left);
        mirror2(n.right);
    }
}
