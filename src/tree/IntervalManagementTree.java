package tree;

/**
 * Created by chace on 6/8/14.
 */

// No overlap
public class IntervalManagementTree {
    IntervalNode root;

    public IntervalManagementTree() {
        this.root = null;
    }

    public IntervalNode find(int start, int end) {
        IntervalNode tmp = new IntervalNode(start, end);
        if (root == null) {
            return null;
        }
        IntervalNode current = root;
        while (current != null && current.compareTo(tmp) != 0) {
            if (current.compareTo(tmp) > 0) {
                current = current.left;
            } else if (current.compareTo(tmp) < 0) {
                current = current.right;
            }
        }
        return current;
    }

    public void insert(int start, int end) {
        IntervalNode newNode = new IntervalNode(start, end);
        if (root == null) {
            root = newNode;
        } else {
            IntervalNode current = root;
            IntervalNode parent;
            while (true) {
                parent = current;
                if (current.compareTo(newNode) > 0) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else if (current.compareTo(newNode) < 0) {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean remove(int start, int end) {
        IntervalNode current = root;
        IntervalNode parent = root;
        boolean isLeftChild = true;
        IntervalNode toRemove = new IntervalNode(start, end);
        while (current.compareTo(toRemove) != 0) {
            parent = current;
            if (current.compareTo(toRemove) > 0) {
                isLeftChild = true;
                current = current.left;
            } else if (current.compareTo(toRemove) < 0) {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }

        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.right == null) {
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
            IntervalNode successor = getSuccessor(current);
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

    private IntervalNode getSuccessor(IntervalNode x) {
        IntervalNode successorParent = x;
        IntervalNode successor = x;
        IntervalNode current = x.right;
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

class IntervalNode implements Comparable<IntervalNode> {
    int start;
    int end;

    IntervalNode left;
    IntervalNode right;

    public IntervalNode(int s, int e) {
        this.start = s;
        this.end = e;
    }

    @Override
    public int compareTo(IntervalNode intervalNode) {
        if (this.start > intervalNode.end) {
            return 1;
        } else if (this.end < intervalNode.start) {
            return -1;
        } else if (this.start == intervalNode.start && this.end == intervalNode.end) {
            return 0;
        }
        return 0;
    }
}