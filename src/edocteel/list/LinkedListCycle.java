package edocteel.list;

import base.ListNode;

/**
 * Created by chace on 5/7/14.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next, fast = head.next.next;
        while (fast != null && fast.val != slow.val) {
            slow = slow.next;
            fast = fast.next == null ? fast.next : fast.next.next;
        }
        if (fast == null) {
            return false;
        } else if (fast.val == slow.val) {
            return true;
        }
        return false;
    }
}
