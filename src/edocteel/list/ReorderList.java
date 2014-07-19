package edocteel.list;

import base.ListNode;

/**
 * Created by chace on 5/15/14.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next = null;

        head2 = reverse(head2);

        while (head2 != null) {
            ListNode t1 = head1.next;
            ListNode t2 = head2.next;
            head1.next = head2;
            head2.next = t1;
            head1 = t1;
            head2 = t2;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null, next = null;
        ListNode curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {

    }
}
