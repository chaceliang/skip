package edocteel.list;

import base.ListNode;

public class RemoveDuplicateFromSortedListII {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode current = dummy;
		while (current.next != null) {
			ListNode prev = current;
			current = current.next;
			boolean isDuplicate = false;
			
			while (current != null && current.next != null && current.val == current.next.val) {
				current = current.next;
				isDuplicate = true;
			}
			prev.next = isDuplicate ? current.next : current;
			current = isDuplicate ? prev : current;
		}
		return dummy.next;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
