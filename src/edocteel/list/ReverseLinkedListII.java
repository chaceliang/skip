package edocteel.list;

import base.ListNode;

public class ReverseLinkedListII {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode start = new ListNode(-1);
		start.next = head;
		ListNode low = start;
		ListNode high = start;
		for (int i = 0; i < m -1; i++) {
			low = low.next;
		}
		ListNode p1 = low;
		low = low.next;
		for (int i = 0; i < n; i++) {
			high = high.next;
		}
		ListNode p2 = high.next;
		high.next = null;
		p1.next = reverseList(low);
		while (p1.next != null) {
			p1 = p1.next;
		}
		p1.next = p2;
		return start.next;
	}
	
	public ListNode reverseList(ListNode head) {
		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;
		while (current != null) {
			next = head.next;
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
		// TODO Auto-generated method stub

	}

}
