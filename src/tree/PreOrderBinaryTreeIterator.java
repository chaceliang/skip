package tree;

import base.TreeNode;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by chace on 6/4/14.
 */
public class PreOrderBinaryTreeIterator implements PreOrderBinaryTreeIteratorInterface {
    Stack<TreeNode> stack = new Stack<TreeNode>();

    public PreOrderBinaryTreeIterator(TreeNode root) {
        if (root != null) {
            stack.push(root);
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("All nodes have been visited!");
        }

        TreeNode res = stack.pop();
        if (res.right != null) {
            stack.push(res.right);
        }
        if (res.left != null) {
            stack.push(res.left);
        }
        return res.val;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

interface PreOrderBinaryTreeIteratorInterface extends Iterator<Integer> {
    /** Returns the next integer a in the pre-order traversal of the given binary tree.
     * For example, given a binary tree below,
     *       4
     *      / \
     *     2   6
     *    / \ / \
     *   1  3 5  7
     * the outputs will be 4, 2, 1, 3, 6, 5, 7.
     */
    public Integer next();

    /** Return true if traversal has not finished; otherwise, return false.
     */
    public boolean hasNext();
}