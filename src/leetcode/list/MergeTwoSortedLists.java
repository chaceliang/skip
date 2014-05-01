package leetcode.list;

import base.ListNode;

public class MergeTwoSortedLists {

	public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode l = head;
		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				if (l1.val > l2.val) {
					if (l == null) {
						l = new ListNode(l2.val);
						head = l;
					} else {
						l.next = new ListNode(l2.val);
						l = l.next;
					}
					l2 = l2.next;
				} else {
					if (l == null) {
						l = new ListNode(l1.val);
						head = l;
					} else {
						l.next = new ListNode(l1.val);
						l = l.next;
					}
					l1 = l1.next;
				}
			} else if (l1 != null) {
				if (l == null) {
					return l1;
				} else {
					l.next = new ListNode(l1.val);
					l = l.next;
				}
				l1 = l1.next;
			} else {
				if (l == null) {
					return l2;
				} else {
					l.next = new ListNode(l2.val);
					l = l.next;
				}
				l2 = l2.next;
			}
		}
		return head;
	}
	
	public ListNode mergeTwoSortedLists2(ListNode l1, ListNode l2) {
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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
