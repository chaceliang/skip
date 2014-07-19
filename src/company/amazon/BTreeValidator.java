package company.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chace on 6/28/14.
 */
public class BTreeValidator {

    public boolean valid(Node root) {
        if (root == null) {
            throw new NullPointerException();
        }
        if (root.children == null || root.children.size() == 0) {
            return true;
        }
        // Invalid Input
        if (root.children.size() < 2) {
            return false;
        }
        return validUtil(root.children.get(0), Integer.MIN_VALUE, root.keys.get(0)) &&
                validUtil(root.children.get(1), root.keys.get(0), Integer.MAX_VALUE);
    }

    public boolean validUtil(Node node, int min, int max) {
        // Just make sure keys are sorted
        for (int i = 0; i < node.keys.size(); i++) {
            if (i != node.keys.size() - 1 && node.keys.get(i) > node.keys.get(i+1)) {
                return false;
            }
            // If invalid key, return false
            int key = node.keys.get(i);
            if (key <= min || key >= max) {
                return false;
            }
        }
        // Empty children list.
        if (node.children == null || node.children.size() == 0) {
            return true;
        }
        int keySize = node.keys.size();
        int childrenSize = node.children.size();
        // Invalid input
        if (keySize+1 != childrenSize) {
            return false;
        }

        for (int i = 0; i < childrenSize; i++) {
            Node curr = node.children.get(i);
            if (i == 0) {
                if (!validUtil(curr, min, node.keys.get(i))) {
                    return false;
                }
            } else if (i == childrenSize - 1) {
                if (!validUtil(curr, node.keys.get(keySize - 1), max)) {
                    return false;
                }
            } else {
                if (!validUtil(curr, node.keys.get(i-1), node.keys.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test case 1
        Node root1 = new Node(new int[] {13});
        Node a1 = new Node(new int[] {4, 7});
        Node b1 = new Node(new int[] {17, 24});
        root1.children.add(a1); root1.children.add(b1);

        BTreeValidator test1 = new BTreeValidator();
        System.out.println(test1.valid(root1));
        assert test1.valid(root1) == true;

        // Test case 2
        Node root2 = new Node(new int[] {13});
        Node a2 = new Node(new int[] {4, 17});
        Node b2 = new Node(new int[] {18, 24});
        root2.children.add(a2); root2.children.add(b2);

        BTreeValidator test = new BTreeValidator();
        System.out.println(test.valid(root2));
        assert test.valid(root2) == false;
    }
}

class Node {
    List<Integer> keys;
    List<Node> children;

    public Node(int[] keys) {
        this.keys = new ArrayList<Integer>();
        this.children = new ArrayList<Node>();
        for (int key : keys) {
            this.keys.add(key);
        }
    }
}