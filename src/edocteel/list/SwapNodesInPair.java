package edocteel.list;

import base.ListNode;

public class SwapNodesInPair {

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            ListNode tmp = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            tmp.next = cur.next;
            cur.next = tmp;
            cur = cur.next;
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
