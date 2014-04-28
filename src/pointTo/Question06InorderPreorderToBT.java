package pointTo;

import java.util.ArrayList;
import java.util.List;

import base.TreeNode;
import base.TreeUtils;

public class Question06InorderPreorderToBT {
	
	public static TreeNode constructBST(List preorder, List inorder, int preorderIndex, int inorderIndex, int length) {
		if (length == 0) {
			return null;
		}
		int v = ((Integer)preorder.get(preorderIndex)).intValue();
		TreeNode node = new TreeNode(v);
		
		int rootIndex = 0;
		for (int i = inorderIndex; i < inorder.size(); i++) {
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
		List<Integer> preorder = new ArrayList<Integer>();
		preorder.add(1); preorder.add(2); preorder.add(4); preorder.add(7);
		preorder.add(3); preorder.add(5); preorder.add(6); preorder.add(8);
		
		List<Integer> inorder = new ArrayList<Integer>();
		inorder.add(4); inorder.add(7); inorder.add(2); inorder.add(1);
		inorder.add(5); inorder.add(3); inorder.add(8); inorder.add(6);
		
		TreeUtils.printTreeInorder(constructBST(preorder, inorder, 0, 0, 8));
	}

}
