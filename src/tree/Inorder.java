package tree;

import base.TreeNode;

import java.util.ArrayList;

/**
 * Created by chace on 5/27/14.
 */
public class Inorder {

    public static ArrayList<Integer> inorder(TreeNode cur) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        if (cur == null) {
            return results;
        }
        while (cur != null) {
            if (cur.left != null) {
                TreeNode prv = cur.left;
                while (prv.right != null || prv.right != cur) {
                    prv = prv.right;
                }
                if (prv.right == null) {
                    prv.right = cur;
                    cur = cur.left;
                } else {
                    prv.right = null;
                    results.add(prv.val);
                    cur = cur.right;
                }
            } else {
                results.add(cur.val);
                cur = cur.right;
            }
        }
        return results;
    }
}
