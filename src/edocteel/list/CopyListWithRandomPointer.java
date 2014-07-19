package edocteel.list;

import java.util.HashMap;

/**
 * Created by chace on 5/8/14.
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }

        RandomListNode p = head;
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }

        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        p = head;
        RandomListNode cur = p.next;
        RandomListNode newHead = cur;
        while (p != null) {
            p.next = cur.next;
            if (p.next != null) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
            p = p.next;
        }
        return newHead;
    }

    public RandomListNode copyRandomListMap(RandomListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> orig_copy = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);

        RandomListNode p = head;
        RandomListNode q = newHead;
        orig_copy.put(head, newHead);
        p = p.next;
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            orig_copy.put(p, copy);
            q.next = copy;
            q = q.next;
            p = p.next;
        }
        p = head;
        q = newHead;
        while (p != null) {
            if (p.random != null) {
                q.random = orig_copy.get(p.random);
            } else {
                q.random = null;
            }
            p = p.next;
            q = q.next;
        }
        return newHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}