package pointTo;

import base.ListNode;

public class Question16ReverseList {
	
	public static ListNode reverse(ListNode head) {
		ListNode previous = null;
		ListNode current = head;
		ListNode next = null;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode node = ListNode.giveMeAList();
		ListNode tail = reverse(null);
		while (tail != null) {
			System.out.print(tail.value + " ");
			tail = tail.next;
		}
		System.out.println();

	}

}
