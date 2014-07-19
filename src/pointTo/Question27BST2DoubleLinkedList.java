package pointTo;

import base.TreeNode;

public class Question27BST2DoubleLinkedList {
	
	public static void join(TreeNode a, TreeNode b) {
        a.right = b;
        b.left = a;
    }
	
	public static TreeNode append(TreeNode a, TreeNode b) {
        // if either is null, return the other
        if (a == null) return b;
        if (b == null) return a;
        
        // find the last node in each using the .previous pointer
        TreeNode aLast = a.left;
        TreeNode bLast = b.left;
        
        // join the two together to make it connected and circular
        join(aLast, b);
        join(bLast, a);
        
        return a;
    }

	public static TreeNode treeToList(TreeNode root) {
        // base case: empty tree -> empty list
        if (root == null) return null;
        
        // Recursively do the subtrees (leap of faith!)
        TreeNode aList = treeToList(root.left);
        TreeNode bList = treeToList(root.right);
        
        // Make the single root node into a list length-1
        // in preparation for the appending
        root.left = root;
        root.right = root;
        
        // At this point we have three lists, and it's
        // just a matter of appending them together
        // in the right order (aList, root, bList)
        aList = append(aList, root);
        aList = append(aList, bList);
        
        return(aList);
    }
	
	public static void printTree(TreeNode root) {
        if (root==null) return;
        printTree(root.left);
        System.out.print(Integer.toString(root.val) + " ");
        printTree(root.right);
    }
    
    
    // Do a traversal of the list and print it out
    public static void printList(TreeNode head) {
    	TreeNode current = head;
        
        while (current != null) {
            System.out.print(Integer.toString(current.val) + " ");
            current = current.right;
            if (current == head) break;
        }
        
        System.out.println();
    }
    
    public static void treeInsert(TreeNode root, int newData) {
        if (newData<=root.val) {
            if (root.left!=null) treeInsert(root.left, newData);
            else root.left = new TreeNode(newData);
        }
        else {
            if (root.right!=null) treeInsert(root.right, newData);
            else root.right = new TreeNode(newData);
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
        treeInsert(root, 2);
        treeInsert(root, 1);
        treeInsert(root, 3);
        treeInsert(root, 5);
        
        System.out.println("tree:");
        printTree(root);   // 1 2 3 4 5
        System.out.println();
        
        System.out.println("list:");
        TreeNode head = treeToList(root);
        printList(head);   // 1 2 3 4 5   yay!
	}

}