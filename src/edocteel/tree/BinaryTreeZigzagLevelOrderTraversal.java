package edocteel.tree;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by chace on 5/3/14.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> queue = new Stack<TreeNode>();
        queue.add(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<Integer>();
            Stack<TreeNode> p = new Stack<TreeNode>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                level.add(node.val);
                if (leftToRight) {
                    if (node.left != null) {
                        p.add(node.left);
                    }
                    if (node.right != null) {
                        p.add(node.right);
                    }
                } else {
                    if (node.right != null) {
                        p.add(node.right);
                    }
                    if (node.left != null) {
                        p.add(node.left);
                    }
                }
            }
            leftToRight = !leftToRight;
            result.add(level);
            queue = p;
        }
        return result;
    }

}
