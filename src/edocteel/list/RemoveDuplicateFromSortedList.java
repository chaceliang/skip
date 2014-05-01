package edocteel.list;

import base.ListNode;

public class RemoveDuplicateFromSortedList {

	public ListNode deleteDuplicate(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode l = head;
		int currentValue = l.val;
		l = l.next;
		ListNode r = l;
		while (l != null && r != null) {
			if (r.val == currentValue) {
				r = r.next;
			} else {
				l.next = r;
				l = l.next;
				r = r.next;
			}
		}
		return head;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
