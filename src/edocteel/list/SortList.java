package edocteel.list;

import base.ListNode;

public class SortList {
	
	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode l = head;
		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				if (l1.val > l2.val) {
					l.next = new ListNode(l2.val);
					l2 = l2.next;
				} else {
					l.next = new ListNode(l1.val);
					l1 = l1.next;
				}
			} else if (l1 != null) {
				l.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				l.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			l = l.next;
		}
		return head.next;
	}
	
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = slow.next;
		slow.next = null;
		slow = sortList(head);
		fast = sortList(fast);
		return merge(slow, fast);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
