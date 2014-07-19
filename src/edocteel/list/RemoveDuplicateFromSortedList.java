package edocteel.list;

import base.ListNode;

public class RemoveDuplicateFromSortedList {

	public ListNode deleteDuplicate(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode l = head;
		
		while (l.next != null) {
			ListNode p = l.next;
			while (p != null && p.val == l.val) {
				p = p.next;
			}
			if (p == null) {
				l.next = null;
				break;
			}
			l.next = p;
			l = l.next;
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
