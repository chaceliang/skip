package tree;

import java.util.HashSet;

/**
 * Created by chace on 6/4/14.
 */
public class FirstCommonAncestor {
    public static NodeWithParent firstCommonAncestor(NodeWithParent node1, NodeWithParent node2) {
        HashSet<NodeWithParent> visited = new HashSet<NodeWithParent>();
        NodeWithParent c1 = node1, c2 = node2;
        while (c1 != null) {
            visited.add(c1);
            c1 = c1.parent;
        }

        while (c2 != null) {
            if (visited.contains(c2)) {
                return c2;
            }
            c2 = c2.parent;
        }
        return null;
    }

    public static NodeWithParent firstCommonAncestor(NodeWithParent root, NodeWithParent node1, NodeWithParent node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }
        if (root.value == node1.value || root.value == node2.value) {
            return root;
        }

        NodeWithParent left = firstCommonAncestor(root.left, node1, node2);
        NodeWithParent right = firstCommonAncestor(root.right, node1, node2);

        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

}

class NodeWithParent {
    int value;
    NodeWithParent left;
    NodeWithParent right;
    NodeWithParent parent;

    public NodeWithParent(int v) {
        this.value = v;
    }
}
