package tree;

import base.TreeNode;

/**
 * Created by chace on 6/7/14.
 */
public class ClosestValueInBST {

    static int closest = Integer.MAX_VALUE;
    public static int closestValueInBST(TreeNode root, int value) {
        if (root == null) {
            return closest;
        }
        if (Math.abs(root.val - value) < Math.abs(closest - value)) {
            closest = root.val;
        }
        if (value > root.val) {
            return closestValueInBST(root.right, value);
        } else if (value < root.val) {
            return closestValueInBST(root.left, value);
        }
        return closest;
    }
}
