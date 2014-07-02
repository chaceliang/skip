package tree;

import base.TreeNode;
import base.TreeUtils;
import base.Utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by chace on 6/28/14.
 */
public class SinkZerosInBinaryTree {
    public static void sink0(TreeNode node, Queue<TreeNode> queue) {
        if (node.val == 0) {
            queue.offer(node);
        } else if (queue.size() > 0){
            TreeNode zero = queue.poll();
            zero.val = node.val;
            node.val = 0;
            queue.offer(node);
        }

        if (node.left != null) {
            sink0(node.left, queue);
        }
        if (node.right != null) {
            sink0(node.right, queue);
        }

        if (queue.size() > 0) {
            TreeNode zero = queue.poll();
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(3);

        TreeUtils.printTreeByLevel(root);

        sink0(root, new LinkedList<TreeNode>());
        TreeUtils.printTreeByLevel(root);
    }
}
