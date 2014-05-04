package base;

public class TreeUtils {

	public static void printTreeByLevel(TreeNode root) {
		
	}
	
	public static void printTreeInorder(TreeNode node) {
		if (node == null) {
			return;
		}
		printTreeInorder(node.left);
		System.out.print(node.val + " ");
		printTreeInorder(node.right);
	}

    public static boolean isBSTNode(TreeNode node) {
        if (node == null) {
            return true;
        }
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        if (node.left != null) {
            left = node.left.val;
        }
        if (node.right != null) {
            right = node.right.val;
        }
        return node.val > left && node.val < right;
    }

    public static void swapNode(TreeNode n1, TreeNode n2) {
        TreeNode tmp = n1;
        n1 = n2;
        n2 = tmp;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
