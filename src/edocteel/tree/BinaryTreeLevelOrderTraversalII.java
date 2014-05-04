package edocteel.tree;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chace on 5/3/14.
 */
public class BinaryTreeLevelOrderTraversalII {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> tmp = new LinkedList<TreeNode>();
        tmp.add(root);
        while (!tmp.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = tmp.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = tmp.poll();
                level.add(node.val);
                if (node.left != null) {
                    tmp.add(node.left);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                }
            }
            result.add(0, level);
        }
        return result;
    }
}
