package array;

import base.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by chace on 6/2/14.
 */
public class SlidingWindowMaximum {

    public static int[] windowMax(int[] A, int window) {
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
        for (i = w; i < A.length; i++) {
            max[i-w] = A[que.getFirst()];
            while (!que.isEmpty() && A[i] >= A[que.getLast()]) {
                que.pollLast();
            }

            while (!que.isEmpty() && que.getFirst() <= i - w) {
                que.pollFirst();
            }
            que.offerLast(i);
        }
        max[i-w] = A[que.getFirst()];
        return max;
    }

    public static void main(String[] args) {
        int[] A = {1,3,-1,-3,5,3,6,7};
        Utils.printArray(windowMax(A, 3));
    }
}
