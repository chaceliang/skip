package edocteel.list;

import base.ListNode;

public class RotateList {
	
	public static ListNode rotateRight(ListNode head, int n) {
		if (head == null) {
			return head;
		}
		int length = 1;
		ListNode last = head;
		while (last.next != null) {
			last = last.next;
			length++;
		}
		n = n % length;
		if (n == 0) {
			return head;
		}
		int steps = length - n - 1;
		ListNode start = head;
		while (steps > 0) {
			start = start.next;
			steps--;
		}
		ListNode ret = start.next;
		start.next = null;
		last.next = head;
		return ret;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		rotateRight(head, 1);
	}

}
