package leetcode.list;

import base.ListNode;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode head = new ListNode(-1);
		ListNode l = head;
		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				l.next = new ListNode((l1.val + l2.val + carry) % 10);
				carry = (l1.val + l2.val + carry) / 10;
				l1 = l1.next;
				l2 = l2.next;
			} else if (l1 != null) {
				l.next = new ListNode((l1.val + carry) % 10);
				carry = (l1.val + carry) / 10;
				l1 = l1.next;
			} else {
				l.next = new ListNode((l2.val + carry) % 10);
				carry = (l2.val + carry) / 10;
				l2 = l2.next;
			}
			l = l.next;
		}
		if (carry != 0) {
			l.next = new ListNode(carry);
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
