package array;

import base.Utils;

/**
 * Created by chace on 5/22/14.
 */
public class InterleaveArray {
    // a1a2a3b1b2b3 => a1b1a2b2a3b3

    public void interleave(int[] A) {
        if (A == null) {
            throw new NullPointerException();
        }
        int len = A.length;
        for (int i = len/2-1; i >= 1; i--) {
            for (int j = i; j < len - i - 1; j += 2) {
                swap(A, j, j+1);
            }
        }
    }

    public void reverse(int[] A) {
        if (A == null) {
            throw new NullPointerException();
        }
        int len = A.length;
        for (int i = 1; i <= len/2 - 1; i++) {
            for (int j = i; j < len - i - 1; j += 2) {
                swap(A, j, j+1);
            }
        }
    }

    public void interleave1(int[] A) {
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

    public static void main(String[] args) {
        int[] A = new int[] {1,2,3,4,5,6,7,8};
        InterleaveArray test = new InterleaveArray();
        test.interleave(A);
        Utils.printArray(A);
        test.reverse(A);
        Utils.printArray(A);
    }
}
