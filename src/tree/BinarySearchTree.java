package tree;

/**
 * Created by chace on 6/3/14.
 */
public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public Node find(int value) {
        Node current = root;
        if (current == null) {
            return current;
        }
        while (current.value != value) {
            if (current.value < value) {
                current = current.right;
            } else if (current.value > value) {
                current = current.left;
            }
            if (current == null) {
                return current;
            }
        }
        return current;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (current.value > value) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean remove(int value) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.value != value) {
            parent = current;
            if (current.value > value) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }

        // Delete leaf
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.right == null) { // Right subtree is empty
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    private Node getSuccessor(Node x) {
        Node successorParent = x;
        Node successor = x;
        Node current = x.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if (successor != x.right) {
            successorParent.left = successor.right;
            successor.right = x.right;
        }
        successor.left = x.left;
        return successor;
    }
}

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int v) {
        this.value = v;
    }
}
