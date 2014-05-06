package edocteel.tree;

import base.TreeNode;

/**
 * Created by chace on 5/5/14.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) {
            return false;
        }
        if(root.right==null && root.left==null) {
            return sum==root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
