package pointTo;

import base.ListNode;

public class Question16PrintLastKNodeInList {
	
	public static ListNode findLastKNode(ListNode head, int k) {
		if (k < 0 || head == null) {
			return null;
		}
		ListNode n = head;
		while (k > 0 && n != null) {
			n = n.next;
			k--;
		}
		if (k > 0) {
			return null;
		}
		ListNode kn = head;
		while (n != null) {
			kn = kn.next;
			n = n.next;
		}
		return kn;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head1 = new ListNode(5);
		head1.next = new ListNode(4);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(2);
		head1.next.next.next.next = new ListNode(1);
		head1.next.next.next.next.next = new ListNode(0);
		// 5->4->3->2->1->0
		System.out.println(findLastKNode(head1, 0) == null ? -1 : findLastKNode(head1, 0).value);
		System.out.println(findLastKNode(head1, 2) == null ? -1 : findLastKNode(head1, 2).value);
		System.out.println(findLastKNode(head1, 6) == null ? -1 : findLastKNode(head1, 6).value);
		System.out.println(findLastKNode(head1, 7) == null ? -1 : findLastKNode(head1, 7).value);
		System.out.println(findLastKNode(null, 7) == null ? -1 : findLastKNode(null, 7).value);
	}

}
