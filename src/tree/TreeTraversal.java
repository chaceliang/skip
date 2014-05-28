package tree;

import base.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by chace on 5/27/14.
 */
public class TreeTraversal {

    public static ArrayList<Integer> inorder(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        if (root == null) {
            return results;
        }
        TreeNode c = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (c != null) {
            stack.push(c);
            c = c.left;
        }

        while (!stack.isEmpty()) {
            c = stack.pop();
            results.add(c.val);
            c = c.right;
            while (c != null) {
                stack.push(c);
                c = c.left;
            }
        }
        return results;
    }

    public static ArrayList<Integer> preorder(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        if (root == null) {
            return results;
        }
        TreeNode c = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (c != null) {
            results.add(c.val);
            stack.push(c);
            c = c.left;
        }
        while (!stack.isEmpty()) {
            c = stack.pop();
            c = c.right;
            while (c != null) {
                results.add(c.val);
                stack.push(c);
                c = c.left;

            }
        }
        return results;
    }

    public static ArrayList<Integer> postorder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> stackBack = new Stack<TreeNode>();
        Stack<Integer> stack = new Stack<Integer>();
        TreeNode cur = root;
        // find the right-most node
        while (cur != null) {
            stack.push(cur.val);
            stackBack.push(cur);
            cur = cur.right;
        }
        while (!stackBack.empty()) {
            cur = stackBack.pop();
            // add the left child
            cur = cur.left;
            // find the right-most node
            while (cur != null) {
                stack.push(cur.val);
                stackBack.push(cur);
                cur = cur.right;
            }
        } // while-stackBack-empty
        // pop values to an array
        while (!stack.empty()) {
            res.add(stack.pop());
        }
        return res;
    }
}
