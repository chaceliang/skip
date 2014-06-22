package tree;

import base.TreeNode;

import java.util.ArrayList;

/**
 * Created by chace on 6/22/14.
 */
public class PrintAllPathsInBinaryTree {
    public static void printAllPaths(TreeNode root) {
        printAllPathsUtil(root, new ArrayList<TreeNode>());
    }

    public static void printAllPathsUtil(TreeNode n, ArrayList<TreeNode> path) {
        if (n == null) {
            return;
        }
        path.add(n);
        if (n.left == null && n.right == null) {
            System.out.println(path);
            path.remove(path.size() - 1);
        } else {
            printAllPathsUtil(n.left, path);
            printAllPathsUtil(n.right, path);
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.right.right = new TreeNode(10);

        printAllPaths(root);
    }
}
