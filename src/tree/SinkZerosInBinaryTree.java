package tree;

import base.TreeNode;

import java.util.Stack;

/**
 * Created by chace on 6/28/14.
 */
public class SinkZerosInBinaryTree {
    public static void sink0(TreeNode node, Stack<TreeNode> stack) {
        if (node.val == 0) {
            stack.push(node);
        }
        if (node.left != null) {
            sink0(node.left, stack);
        }
        if (node.right != null) {
            sink0(node.right, stack);
        }

        if (stack.size() > 0) {
            TreeNode zero = stack.pop();
            zero.val = node.val;
            node.val = 0;
        }
    }

    public static void sink02(TreeNode node, Stack<TreeNode> stack) {
        if (node.val == 0) {
            stack.push(node);
        } else if (!stack.isEmpty()) {
            TreeNode zero = stack.pop();
            zero.val = node.val;
            node.val = 0;
            stack.push(node);
        }
        if (node.left != null) {
            sink02(node.left, stack);
        }
        if (node.right != null) {
            sink02(node.right, stack);
        }
    }
}
