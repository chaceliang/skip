package edocteel.tree;

import base.TreeNode;

import java.util.ArrayList;

/**
 * Created by chace on 5/5/14.
 */
public class PathSumII {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return results;
        }
        helper(results, new ArrayList<Integer>(), root, sum);
        return results;
    }

    public void helper(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result, TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                result.add(root.val);
                results.add((ArrayList<Integer>) result.clone());
                result.remove(result.size() - 1);
        }
        } else {
            result.add(root.val);
            helper(results, result, root.left, sum - root.val);
            helper(results, result, root.right, sum - root.val);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        PathSumII test = new PathSumII();
        test.pathSum(root, 1);
    }
}
