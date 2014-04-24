package base;

public class TreeUtils {

	public static void printTreeByLevel(TreeNode root) {
		
	}
	
	public static void printTreeInorder(TreeNode node) {
		if (node == null) {
			return;
		}
		printTreeInorder(node.left);
		System.out.print(node.value + " ");
		printTreeInorder(node.right);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
