package edocteel.list;

import base.ListNode;

public class RemoveNthFromEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(-1);
        ListNode fast = root;
        ListNode slow = root;
        root.next = head;
        int count = 0;
        while (fast != null && count < n) {
            fast = fast.next;
            count++;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return root.next;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
