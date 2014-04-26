package pointTo;

import base.ListNode;

public class Question13DeleteNodeInList {
	
	public static void deleteNodeInList(ListNode head, ListNode target) {
		if (head == null || target == null) {
			return;
		}
		if (target.next != null) {
			ListNode next = target.next;
			target.value = next.value;
			target.next = target.next.next;
		} else if (head == target) {
			head = null;
			target = null;
		} else {
			ListNode n = head;
			while (n.next != target) {
				n = n.next;
			}
			n.next = null;
			target = null;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
