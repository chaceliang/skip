package tree;

import base.TreeNode;

import java.util.ArrayList;

/**
 * Created by chace on 6/7/14.
 */
public class SerializeAndDeserializeBT {

    public static String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        if (root == null) {
            return result.toString();
        }
        serialize(result, root);
        return result.toString();
    }

    public static void serialize(StringBuilder result, TreeNode n) {
        if (n == null) {
            result.append("#");
        } else {
            result.append(Integer.toString(n.val));
            result.append("(");
            serialize(result, n.left);
            result.append(")");
            result.append("(");
            serialize(result, n.right);
            result.append(")");
        }
    }

    public static TreeNode deserialize(String input) {
        if (input == null) {
            return null;
        }
        int i = 0;
        int len = input.length();
        if (input.length() == 1 && input.charAt(i) == '#') {
            return null;
        }
        while (i < len) {
            if (input.charAt(i) != '(') {
                i++;
            } else {
                break;
            }
        }
        int rootValue = Integer.parseInt(input.substring(0, i));
        TreeNode root = new TreeNode(rootValue);
        int backetCount = 0;
        while (i < len) {
            if (input.charAt(i) == '(') {
                backetCount++;
            } else if (input.charAt(i) == ')') {
                backetCount--;
            }
            if (backetCount == 0) {
                break;
            }
            i++;
         }
        root.left = deserialize(input.substring(2, i));
        root.right = deserialize(input.substring(i+2, len - 1));
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(8);
        System.out.println(serialize(root));

        TreeNode newRoot = deserialize("5(3(#)(#))(7(#)(#))");
        System.out.println(serialize(newRoot));
    }
}
