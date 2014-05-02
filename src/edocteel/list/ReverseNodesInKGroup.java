package edocteel.list;

import base.ListNode;

public class ReverseNodesInKGroup {
	
	public ListNode reverseKGroup(ListNode head, int k) {
		int size = 0;
		ListNode running = head;
		while (running != null) {
			running = running.next;
			size++;
		}
		if (size < k) {
			return head;
		}
		
		ListNode current = head;
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
			head.next = reverseKGroup(next, k);
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
