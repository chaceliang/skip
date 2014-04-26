package base;

public class ListNode {
	public int value;
	public ListNode next;
	
	public ListNode(int v) {
		this.value = v;
		next = null;
	}
	
	public static ListNode giveMeAList() {
		ListNode head1 = new ListNode(5);
		head1.next = new ListNode(4);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(2);
		head1.next.next.next.next = new ListNode(1);
		head1.next.next.next.next.next = new ListNode(0);
		return head1;
	}
	
	public static ListNode giveMeAList(int[] value) {
		ListNode head = null;
		ListNode curr = null;
		for (int i = 0; i < value.length; i++) {
			if (curr == null) {
				curr = new ListNode(value[i]);
				head = curr;
			} else {
				curr.next = new ListNode(value[i]);
				curr = curr.next;
			}
		}
		return head;
	}
	
	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}
}
