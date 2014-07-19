package tree;

import base.TreeNode;

/**
 * Created by chace on 5/26/14.
 */
public class BST {
    public TreeNode root;

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    public int size(TreeNode x) {
        if (x == null) return 0;
        return size(x.left) + size(x.right) + 1;
    }

    public boolean contains(TreeNode x) {
        return get(x.val) == null;
    }

    public TreeNode get(int val) {
        return get(root, val);
    }

    public TreeNode get(TreeNode x, int val) {
        if (x == null) return null;
        if (x.val == val) {
            return x;
        } else if (x.val < val) {
            return get(x.right, val);
        } else {
            return get(x.left, val);
        }
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    public TreeNode insert(TreeNode x, int val) {
        if (x == null) {
            return new TreeNode(val);
        }
        if (x.val > val) {
            x.left = insert(x.left, val);
        } else if (x.val < val) {
            x.right = insert(x.right, val);
        } else {
            x.val = val;
        }
        return x;
    }

    public void deleteMin() {
        if (isEmpty()) {
            return;
        }
        root = deleteMin(root);
    }

    public TreeNode deleteMin(TreeNode x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        return x;
    }

    public void deleteMax() {
        if (isEmpty()) {
            return;
        }
        root = deleteMax(root);
    }

    public TreeNode deleteMax(TreeNode x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        return x;
    }

    public void delete(int val) {
        root = delete(root, val);
    }

    public TreeNode delete(TreeNode x, int val) {
        if (x == null) {
            return null;
        }
        if (x.val < val) {
            x.right = delete(x.right, val);
        } else if (x.val > val) {
            x.left = delete(x.left, val);
        } else {
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            TreeNode t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

    public int min() {
        if (isEmpty()) {
            return -1;
        }
        return min(root).val;
    }

    public TreeNode min(TreeNode x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }

    public int max() {
        if (isEmpty()) {
            return -1;
        }
        return max(root).val;
    }

    public TreeNode max(TreeNode x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }

    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBST(TreeNode x, int min, int max) {
        if (x == null) {
            return true;
        }
        if (x.val <= min || x.val >= max) {
            return false;
        }
        return isBST(x.left, min, x.val) && isBST(x.right, x.val, max);
    }
}
