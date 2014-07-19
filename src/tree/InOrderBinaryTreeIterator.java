package tree;

import base.TreeNode;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by chace on 6/4/14.
 */
public class InOrderBinaryTreeIterator implements InOrderBinaryTreeIteratorInterface {
    Stack<TreeNode> stack = new Stack<TreeNode>();

    private void pushLeftChildren(TreeNode cur) {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

    public InOrderBinaryTreeIterator(TreeNode root) {
        pushLeftChildren(root);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("All nodes have been visited");
        }
        TreeNode res = stack.pop();
        pushLeftChildren(res.right);
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

interface InOrderBinaryTreeIteratorInterface extends Iterator<Integer> {
    /** Returns the next integer a in the in-order traversal of the given binary tree.
     * For example, given a binary tree below,
     *       4
     *      / \
     *     2   6
     *    / \ / \
     *   1  3 5  7
     * the outputs will be 1, 2, 3, 4, 5, 6, 7.
     */
    public Integer next();

    /** Return true if traversal has not finished; otherwise, return false.
     */
    public boolean hasNext();
}
