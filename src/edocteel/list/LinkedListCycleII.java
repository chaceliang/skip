package edocteel.list;

import base.ListNode;

/**
 * Created by chace on 5/7/14.
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next, fast = head.next.next;
        while (fast != null && fast.val != slow.val) {
            slow = slow.next;
            fast = fast.next == null ? fast.next : fast.next.next;
        }
        if (fast == null) {
            return null;
        } else if (fast.val == slow.val) {
            slow = head;
            while (fast.val != slow.val) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
        return null;
    }

    public ListNode abc(ListNode head) {
        if (head == null)
            return head;
        ListNode fast = head, slow = head;
        do {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                return null;
            }
        } while (fast != slow);
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
