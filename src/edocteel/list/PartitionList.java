package edocteel.list;

import base.ListNode;

public class PartitionList {

	public ListNode partitoin(ListNode head, int x) {
		ListNode head1 = new ListNode(-1);
		ListNode l1 = head1;
		ListNode head2 = new ListNode(-1);
		ListNode l2 = head2;
		
		while (head != null) {
			if (head.val < x) {
				l1.next = new ListNode(head.val);
				l1 = l1.next;
			} else {
				l2.next = new ListNode(head.val);
				l2 = l2.next;
			}
			head = head.next;
		}
		if (head1.next == null) {
			return head2.next;
		} else if (head2.next == null) {
			return head1.next;
		} else {
			l1.next = head2.next;
			return head1.next;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
