package array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by chace on 6/2/14.
 */
public class SlidingWindowMaximum {

    public int[] windowMax(int[] A, int window) {
        int w = A.length < window ? A.length : window;

        Deque<Integer> que = new ArrayDeque<Integer>();
        int i = 0;
        while (i < w) {
            while (!que.isEmpty() && A[que.getLast()] <= A[i]) {
                que.removeLast();
            }
            que.addLast(i++);
        }
        int[] max = new int[A.length - w + 1];
        max[0] = que.getFirst();
        while (i < A.length) {
            while (!que.isEmpty() && A[que.getLast()] <= A[i]) {
                que.removeLast();
            }
            que.addLast(i);
            if (!que.isEmpty() && i - w >= que.getFirst()) {
                que.removeFirst();
            }
            i++;
            max[i-w] = que.getFirst();
        }
        return max;
    }
}
