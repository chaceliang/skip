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
}
