package pointTo;

import base.ListNode;

public class Question37FirstCommonNodeInTwoLists {

	public static ListNode firstCommonNodeInTwoLists(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		ListNode p1 = head1;
		ListNode p2 = head2;
		int length1 = 0;
		int length2 = 0;
		
		while (p1 != null) {
			p1 = p1.next;
			length1++;
		}
		while (p2 != null) {
			p2 = p2.next;
			length2++;
		}
		
		int diff = Math.abs(length1 - length2);
		p1 = head1; p2 = head2;
		while (diff > 0) {
			if (length1 > length2) {
				p1 = p1.next;
			} else {
				p2 = p2.next;
			}
			diff--;
		}
		while (p1 != null && p2 != null) {
			if (p1.val == p2.val) {
				return p1;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		return null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
