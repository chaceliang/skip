package tree;

import base.TreeNode;

import java.util.Random;

/**
 * Created by chace on 6/18/14.
 */
public class GetRandomNodeFromTree {

    public static TreeNode getRandomNode(TreeNode root) {
        int total = root.leftChildrenNumber + root.rightChildrenNumber + 1;
        Random rand = new Random();
        int k = rand.nextInt(total+1);
        return getRandomNode(root, k);
    }

    public static TreeNode getRandomNode(TreeNode node, int n) {
        if (n - node.leftChildrenNumber == 1) {
            return node;
        } else if (n < node.leftChildrenNumber) {
            return getRandomNode(node.left, n-1);
        } else {
            return getRandomNode(node.right, n - 1 - node.leftChildrenNumber);
        }
    }
}
