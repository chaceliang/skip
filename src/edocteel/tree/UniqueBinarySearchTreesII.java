package edocteel.tree;

import base.TreeNode;

import java.util.ArrayList;

/**
 * Created by chace on 5/16/14.
 */
public class UniqueBinarySearchTreesII {

    public ArrayList<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return generate(1, 0);
        }
        return generate(1, n);
    }

    public ArrayList<TreeNode> generate(int start, int end) {
        ArrayList<TreeNode> subTree = new ArrayList<TreeNode>();
        if (start > end) {
            subTree.add(null);
            return subTree;
        }

        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> leftSubTree = generate(start, i-1);
            ArrayList<TreeNode> rightSubTree = generate(i+1, end);
            for (int j = 0; j < leftSubTree.size(); j++) {
                for (int k = 0; k < rightSubTree.size(); k++) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftSubTree.get(j);
                    node.right = rightSubTree.get(k);
                    subTree.add(node);
                }
            }
        }

        return subTree;
    }
}
