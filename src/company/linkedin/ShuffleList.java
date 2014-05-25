package company.linkedin;

import base.ListNode;

import java.util.Random;

/**
 * Created by chace on 5/25/14.
 */
public class ShuffleList {

    public void shuffle(ListNode head, int size) {
        ListNode n = head;
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            int r = rand.nextInt(size - i);
            ListNode c = n;
            for (int j = 0; j < r; j++) {
                c = c.next;
            }
            int tmp = n.val;
            n.val = c.val;
            c.val = tmp;
            n = n.next;
        }
    }
}
