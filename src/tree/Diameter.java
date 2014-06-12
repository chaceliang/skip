package tree;

import base.TreeNode;

/**
 * Created by chace on 6/11/14.
 */
public class Diameter {

    public static int getDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int rootDiameter = getHeight(root.left) + getHeight(root.right) + 1;
        int leftDiameter = getDiameter(root.left);
        int rightDiameter = getDiameter(root.right);

        return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
    }

    public static int getHeight(TreeNode n) {
        if (n == null) {
            return 0;
        }
        return Math.max(getHeight(n.left), getHeight(n.right)) + 1;
    }
}
