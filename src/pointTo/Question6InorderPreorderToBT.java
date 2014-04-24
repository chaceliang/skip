package pointTo;

import java.util.List;

import base.TreeNode;

public class Question6InorderPreorderToBT {
	
	public static TreeNode constructBST(List preorder, List inorder, int preorderIndex, int inorderIndex, int length) {
		if (length == 0) {
			return null;
		}
		int v = ((Integer)preorder.get(preorderIndex)).intValue();
		TreeNode node = new TreeNode(v);
		
		int rootIndex = 0;
		for (int i = inorderIndex; i < length; i++) {
			int inorderValue = ((Integer)inorder.get(i)).intValue();
			if (inorderValue == v) {
				break;
			} 
			rootIndex++;
		}
		
		node.left = constructBST(preorder, inorder, preorderIndex + 1, inorderIndex, rootIndex);
		node.right = constructBST(preorder, inorder, preorderIndex + rootIndex + 1, inorderIndex + rootIndex + 1, length - rootIndex - 1);
		return node;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);

	}

}
