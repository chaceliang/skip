package edocteel.list;

import base.ListNode;

import java.util.List;

/**
 * Created by chace on 5/15/14.
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head, cur = null;
        while (node.next != null) {
            cur = node.next;

            if (cur.val >= node.val) {
                node = node.next;
                continue;
            }
            node.next = cur.next;
            if (cur.val <= head.val) {
                cur.next = head;
                head = cur;
                continue;
            }

            ListNode pos = findInsertPos(head, cur);
            cur.next = pos.next;
            pos.next = cur;
        }
        return head;
    }

    public ListNode findInsertPos(ListNode head, ListNode node) {
        ListNode pos = head;
        while (head != null && head.val < node.val) {
            pos = head;
            head = head.next;
        }
        return pos;
    }

}
