package array;

import java.util.Arrays;

/**
 * Created by chace on 6/4/14.
 */
public class UnionOfArrays {

    // A & B are sorted
    public static int[] union(int[] A, int[] B) {
        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }
        int m = A.length, n = B.length;
        int[] result = new int[m+n];
        int xi = 0, yi = 0;
        int ri = 0;
        while (xi < m || yi < n) {
            if (xi < m && yi < n) {
                if (A[xi] < B[yi]) {
                    result[ri] = A[xi++];
                } else if (A[xi] > B[yi]) {
                    result[ri] = A[yi++];
                } else {
                    result[ri] = A[xi++];
                    while (xi < m && A[xi] == result[ri]) {
                        xi++;
                    }
                    while (yi < n && B[yi] == result[ri]) {
                        yi++;
                    }
                }

            } else if (xi < m) {
                while (xi < m && A[xi] == result[ri]) {
                    xi++;
                }
                if (xi < m) {
                    result[ri] = A[xi++];
                }
            } else {
                while (yi < n && B[yi] == result[ri]) {
                    yi++;
                }
                if (yi < n) {
                    result[ri] = B[yi++];
                }
            }
            ri++;
        }
        return Arrays.copyOfRange(result, 0, ri);
    }

    public static void main(String[] args) {
        print(union(new int[]{1,2,2,2,3}, new int[]{2,3,3,3}));
        print(union(new int[]{1,2,2,2,3}, new int[]{2,3,3,3,4,5,6,7}));
        print(union(new int[]{1,2,3}, new int[]{4,5,6,7}));
        print(union(new int[]{2,2,2}, new int[]{2,2,2,2}));
    }

    public static void print(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }
}
