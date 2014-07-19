package edocteel.list;

import base.ListNode;

public class RemoveDuplicateFromSortedListII {

	public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            boolean isDuplicate = false;
            while (next != null && curr.val == next.val) {
                isDuplicate = true;
                next = next.next;
            }
            if (!isDuplicate) {
                prev.next = curr;
                prev = prev.next;
            }
            prev.next = null;
            curr = next;
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
