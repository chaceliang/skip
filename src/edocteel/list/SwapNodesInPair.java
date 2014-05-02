package edocteel.list;

import base.ListNode;

public class SwapNodesInPair {

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		ListNode p = dummy;
		ListNode c = head;
		ListNode n = c;
		while (c != null && c.next != null) {
			n = c.next;
			p.next = n;
			c.next = n.next;
			n.next = c;
			p = c;
			c = c.next;
			n = n.next;
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
