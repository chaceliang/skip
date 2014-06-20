package tree;

import base.TreeNode;
import base.TreeUtils;

import java.util.ArrayList;

/**
 * Created by chace on 6/19/14.
 */
public class LongestPathInBinaryTree {
    static int maxLevel = 0;
    public ArrayList<TreeNode> longestPath(TreeNode root) {
        ArrayList<TreeNode> path = new ArrayList<TreeNode>();
        if (root == null) {
            return path;
        }
        ArrayList<ArrayList<TreeNode>> result = new ArrayList<ArrayList<TreeNode>>();
        longestPathUtil(root, 0, new ArrayList<TreeNode>(), result);
        return result.get(0);
    }

    public void longestPathUtil(TreeNode n, int level, ArrayList<TreeNode> tmpPath, ArrayList<ArrayList<TreeNode>> result) {
        if (n == null) {
            if (level > maxLevel) {
                maxLevel = level;
                ArrayList<TreeNode> path = new ArrayList<TreeNode>(tmpPath);
                result.clear();
                result.add(path);
            }
        } else {
            tmpPath.add(n);
            longestPathUtil(n.left, level+1, tmpPath, result);
            longestPathUtil(n.right, level+1, tmpPath, result);
            tmpPath.remove(tmpPath.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.right.right = new TreeNode(10);

        LongestPathInBinaryTree test = new LongestPathInBinaryTree();
        ArrayList<TreeNode> path = test.longestPath(root);
        for (TreeNode n : path) {
            System.out.println(n.val);
        }
    }

}
