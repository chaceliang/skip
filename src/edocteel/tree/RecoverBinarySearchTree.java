package edocteel.tree;

import base.TreeNode;

import java.util.ArrayList;

/**
 * Created by chace on 5/4/14.
 */
public class RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        inOrder(root, nodes);
        TreeNode a = null, b = null;
        int i;
        for (i = 0; i < nodes.size() - 1; i++) {
            if (nodes.get(i).val > nodes.get(i+1).val) {
                a = nodes.get(i);
                break;
            }
        }
        int j = i+1;
        for (; j < nodes.size() - 1; j++) {
            if (nodes.get(j).val > nodes.get(j+1).val) {
                b = nodes.get(j+1);
                break;
            }
        }
        if (b == null) {
            b = nodes.get(i+1);
        }
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    public void inOrder(TreeNode node, ArrayList<TreeNode> nodes) {
        if (node == null) {
            return;
        }
        inOrder(node.left, nodes);
        nodes.add(node);
        inOrder(node.right, nodes);
    }
}
