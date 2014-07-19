package tree;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by chace on 6/22/14.
 */
public class PrintAllPathsInBinaryTree {
    public static void printAllPaths(TreeNode root) {
        printAllPathsUtil(root, new ArrayList<TreeNode>(), 0);
    }

    public static void printAllPathsUtil(TreeNode n, ArrayList<TreeNode> path, int index) {
        if (n == null) {
            return;
        }
        if (index >= path.size()) {
            path.add(index, n);
        } else {
            path.set(index, n);
        }
        if (n.left == null && n.right == null) {
            System.out.println(path);
            path.remove(path.size() - 1);
        } else {
            printAllPathsUtil(n.left, path, index+1);
            printAllPathsUtil(n.right, path, index+1);
        }
    }

    public static void printAllPathsNonRecursion(TreeNode root) {
        ArrayList<TreeNode> path = new ArrayList<TreeNode>();
        TreeNode curr = root;
        while (true) {
            if (curr == null) {
                break;
            }

            if (curr.left == null && curr.right == null && curr.visited == true) {
                System.out.println(path);
                curr = curr.parent;
                path.remove(path.size() - 1);
            } else if (curr.left != null && !curr.left.visited) {
                if (!curr.visited) {
                    curr.visited = true;
                    path.add(curr);
                }
                curr = curr.left;
            } else if (curr.right != null && !curr.right.visited) {
                if (!curr.visited) {
                    curr.visited = true;
                    path.add(curr);
                }
                curr = curr.right;
            } else {
                if (!curr.visited) {
                    curr.visited = true;
                    path.add(curr);
                } else {
                    curr = curr.parent;
                }
            }
        }
    }

    public static void printPaths(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> nQ = new LinkedList<TreeNode>();
        Queue<ArrayList<Integer>> vQ = new LinkedList<ArrayList<Integer>>();
        TreeNode c = root;
        nQ.offer(c);
        ArrayList<Integer> p = new ArrayList<Integer>();
        p.add(c.val);
        vQ.offer(p);
        while (!nQ.isEmpty()) {
            c = nQ.poll();
            ArrayList<Integer> path = vQ.poll();
            if (c.left == null && c.right == null) {
                for (int i : path) System.out.print(i+" ");
                System.out.println();
                continue;
            }
            if (c.left != null) {
                ArrayList<Integer> tmp = new ArrayList<Integer>(path);
                tmp.add(c.left.val);
                nQ.offer(c.left);
                vQ.offer(tmp);
            }

            if (c.right != null) {
                ArrayList<Integer> tmp = new ArrayList<Integer>(path);
                tmp.add(c.right.val);
                nQ.offer(c.right);
                vQ.offer(tmp);
            }
        }
    }

    public static void printStack(Stack<TreeNode> stack) {
        Stack<TreeNode> tmp = (Stack<TreeNode>)stack.clone();
        while (!tmp.isEmpty()) {
            System.out.print(tmp.pop().val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        printAllPathsUtil(root, new ArrayList<TreeNode>(), 0);
    }
}
