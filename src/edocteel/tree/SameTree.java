package edocteel.tree;

import base.TreeNode;

/**
 * Created by chace on 5/4/14.
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p == null && q == null) {
                return true;
            } else {
                return false;
            }
        }
        return p.val == q.val &&isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
