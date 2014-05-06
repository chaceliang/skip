package edocteel.list;

import base.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by chace on 5/6/14.
 */
public class MergeKSortedList {
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() <= 0) {
            return null;
        }
        Comparator<ListNode> comparator = new NodeComparator();
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(10000, comparator);
        ListNode head = null;
        ListNode current = null;
        for (ListNode n : lists) {
            if (n != null) {
                queue.add(n);
            }
        }
        while (!queue.isEmpty()) {
            ListNode tmp = queue.poll();
            if (head == null) {
                head = tmp;
                current = head;
            } else {
                current.next = tmp;
                current = current.next;
            }
            if (tmp.next != null) {
                queue.add(tmp.next);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ArrayList<ListNode> lists = new ArrayList<ListNode>();
        ListNode node = new ListNode(0);
        node.next = new ListNode(2);
        node.next.next = new ListNode(5);
        lists.add(node);
        mergeKLists(lists);
    }
}

class NodeComparator implements Comparator<ListNode> {

    @Override
    public int compare(ListNode listNode, ListNode listNode2) {
        return listNode.val - listNode2.val;
    }
}