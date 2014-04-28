package pointTo;

import base.ListNode;
import java.util.Stack;

public class Question05PrintListReversing {
	
	public static void recursion(ListNode head) {
		if (head != null) {
			recursion(head.next);
			System.out.print(head.value + " ");
		}
	}

	public static void nonRecursion(ListNode head) {
		Stack<ListNode> stack = new Stack<ListNode>();
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		
		while (!stack.empty()) {
			ListNode n = stack.pop();
			System.out.print(n.value + " ");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(5);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		
		nonRecursion(head);
	}

}
