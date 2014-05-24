package array;

/**
 * Created by chace on 5/22/14.
 */
public class InterleaveArray {
    // a1a2a3b1b2b3 => a1b1a2b2a3b3

    public void interleave(int[] A) {
        if (A == null || A.length <= 0) {
            return;
        }
        int len = A.length;
        int n = len / 2;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                swap(A, n - i + 2 * j, n - i + 2 * j + 1);
            }
        }

    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
