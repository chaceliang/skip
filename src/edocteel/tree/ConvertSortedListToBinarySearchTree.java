package edocteel.tree;

import base.ListNode;
import base.TreeNode;

/**
 * Created by chace on 5/6/14.
 */
public class ConvertSortedListToBinarySearchTree {

    public int length(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, length(head));
    }

    public TreeNode helper(ListNode node, int length) {
        if (node == null || length <= 0) {
            return null;
        }
        if (length == 1) {
            return new TreeNode(node.val);
        }

        ListNode mid = node;
        for (int i = 1; i <= length / 2; i++) {
            mid = mid.next;
        }
        TreeNode root = new TreeNode(mid.val);
        if (length % 2 == 0) {
            root.left = helper(node, length / 2);
            root.right = helper(mid.next, length / 2 - 1);
        } else {
            root.left = helper(node, length / 2);
            root.right = helper(mid.next, length / 2);
        }
        return root;
    }
}
