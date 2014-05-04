package edocteel.tree;

import base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chace on 5/4/14.
 */
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeLinkNode> nextLevelNodes = new LinkedList<TreeLinkNode>();
        TreeLinkNode curLevel = root;
        curLevel.next = null;
        nextLevelNodes.add(curLevel);
        TreeLinkNode cur = null;
        while (!nextLevelNodes.isEmpty()) {
            cur = nextLevelNodes.get(0);
            nextLevelNodes.remove(0);
            while (cur != null) {
                if (cur.left != null) {
                    nextLevelNodes.add(cur.left);
                }
                if (cur.right != null) {
                    nextLevelNodes.add(cur.right);
                }
                cur = cur.next;
            }
            for (int i = 0; i < nextLevelNodes.size() - 1; i++) {
                nextLevelNodes.get(i).next = nextLevelNodes.get(i+1);
            }
            if (nextLevelNodes.size() > 0) {
                TreeLinkNode nextHead = nextLevelNodes.get(0);
                nextLevelNodes.clear();
                nextLevelNodes.add(nextHead);
            }
        }
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
