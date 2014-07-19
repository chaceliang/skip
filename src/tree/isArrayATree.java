package tree;

import base.TreeNode;

import java.util.*;

/**
 * Created by chace on 6/11/14.
 */
public class isArrayATree {

    public static boolean isTree(TreeNode[] A) {
        Hashtable<TreeNode, TreeNode> backtrack = new Hashtable<TreeNode, TreeNode>();
        Set<TreeNode> dict = new HashSet<TreeNode>();
        for (int i = 0; i < A.length; i++) {
            dict.add(A[i]);
        }
        for (int i = 0; i < A.length; i++) {
            TreeNode tmp = A[i];
            if (tmp.left != null && dict.contains(tmp.left)) {
                if (backtrack.contains(tmp.left) && backtrack.get(tmp.left) != null) {
                    return false;
                }
                backtrack.put(tmp.left, tmp);
            }
            if (tmp.right != null && dict.contains(tmp.right)) {
                if (backtrack.contains(tmp.right) && backtrack.get(tmp.right) != null) {
                    return false;
                }
                backtrack.put(tmp.right, tmp);
            }
            if (!backtrack.contains(tmp)) {
                backtrack.put(tmp, null);
            }
        }
        TreeNode root = null;
        for (TreeNode n : backtrack.keySet()) {
            if (backtrack.get(n) == null) {
                if (root != null) {
                    return false;
                }
                root = backtrack.get(n);
            }
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            backtrack.remove(curr);
            if (curr.left != null && dict.contains(curr.left)) {
                queue.add(curr.left);
            }
            if (curr.right != null && dict.contains(curr.right)) {
                queue.add(curr.right);
            }
        }
        return backtrack.size() == 0;
    }
}
