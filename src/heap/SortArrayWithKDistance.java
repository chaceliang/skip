package heap;

import java.util.PriorityQueue;

/**
 * Created by chace on 6/2/14.
 */
public class SortArrayWithKDistance {

    public static void sort(int[] A, int k) {
        if (A == null || A.length <= 0) return;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k+1);
        int len = A.length;
        for (int i = 0; i <= k && i < len; i++) {
            minHeap.add(A[i]);
        }
        for (int i = k+1, ti = 0; ti < len; i++, ti++) {
            if (i < len) {
                A[ti] = minHeap.poll();
                minHeap.add(A[i]);
            } else {
                A[ti] = minHeap.poll();
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {2,6,3,12,56,8};
        sort(A, 3);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}
