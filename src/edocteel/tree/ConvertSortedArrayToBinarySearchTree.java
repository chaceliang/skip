package edocteel.tree;

import base.TreeNode;

/**
 * Created by chace on 5/6/14.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length <= 0) {
            return null;
        }
        return helper(num, 0, num.length - 1);
    }

    public TreeNode helper(int[] num, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            TreeNode node = new TreeNode(num[mid]);
            node.left = helper(num, start, mid - 1);
            node.right = helper(num, mid + 1, end);
            return node;
        } else if (start == end) {
            return new TreeNode(num[start]);
        } else {
            return null;
        }
    }
}
