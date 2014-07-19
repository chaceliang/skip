package list;

import base.ListNode;

public class ReverseListInKGroup {
	
	public static ListNode reverseListInKGroup(ListNode head, int k) {
		int size = 0;
		ListNode current = head;
		while (current != null) {
			size++;
			current = current.next;
		}
		if (size < k) {
			return head;
		}
		
		current = head;
		ListNode previous = null;
		ListNode next = null;
		int count = 0;
		
		while (current != null && count < k) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
			count++;
		}
		
		if (next != null) {
			head.next = reverseListInKGroup(next, k);
		}
		return previous;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head1 = ListNode.giveMeAList();
		head1 = reverseListInKGroup(head1, 3);
		ListNode.printList(head1);

	}

}
