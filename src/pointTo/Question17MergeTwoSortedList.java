package pointTo;

import base.ListNode;

public class Question17MergeTwoSortedList {

	public static ListNode mergeSortedList(ListNode head1, ListNode head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		ListNode mergeHead = null;
		if (head1.value > head2.value) {
			mergeHead = head2;
			mergeHead.next = mergeSortedList(head1, head2.next);
		} else {
			mergeHead = head1;
			mergeHead.next = mergeSortedList(head1.next, head2);
		}
		return mergeHead;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head1 = ListNode.giveMeAList(new int[] {1,3,5,7,9});
		ListNode head2 = ListNode.giveMeAList(new int[] {2,4,6,8,10});
		ListNode node = mergeSortedList(head1, head2);
		ListNode.printList(node);
	}

}
