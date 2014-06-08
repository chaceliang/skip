package tree;

import base.TreeNode;

/**
 * Created by chace on 6/8/14.
 */
public class GetNext {

    public TreeNode getMin(TreeNode n) {
        TreeNode curr = n;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public TreeNode getNext(TreeNode root, TreeNode n) {
        if (n == null) {
            throw new NullPointerException();
        }
        if (n.right != null) {
            return getMin(n.right);
        }

        TreeNode parent = root;
        TreeNode curr = root;
        while (curr != n) {
            if (curr.val > n.val) {
                parent = curr;
                curr = curr.left;
            } else if (curr.val < n.val) {
                curr = curr.right;
            }
        }
        return parent;
    }

    // With parent pointer
    public TreeNode getNext(TreeNode n) {
        if (n == null) {
            throw new NullPointerException();
        }
        if (n.right != null) {
            return getMin(n.right);
        }

        TreeNode tmp = n;
        while (tmp.parent != null) {
            if (tmp == tmp.parent.left) {
                return tmp.parent;
            }
            tmp = tmp.parent;
        }
        return null;
    }
}
