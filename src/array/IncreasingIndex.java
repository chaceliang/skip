package array;

/**
 * Created by Chace on 7/20/14.
 */
public class IncreasingIndex {

    public static void increasingIndex(int[] A) {
        if (A == null) {
            throw new NullPointerException();
        }
        int len = A.length;
        int[] minIndex = new int[len];
        int[] maxIndex = new int[len];

        int index = 0;
        minIndex[0] = 0;
        int t;
        for (t = 0; t < len; t++) {
            if (A[t] < A[index]) {
                index = t;
            }
            minIndex[t] = index;
        }

        index = len - 1;
        for (t = len - 1; t >= 0; t--) {
            if (A[t] > A[index]) {
                index = t;
            }
            maxIndex[t] = index;
        }

        for (t = 1; t < len - 1; t++) {
            if (minIndex[t] < t && t < maxIndex[t]) {
                break;
            }
        }

        if (t < len - 1) {
            System.out.println(minIndex[t] + ", " + t + ", " + maxIndex[t]);
        } else {
            System.out.println(-1 + ", " + -1 + ", " + -1);
        }
    }

    public static void increasingIndex2(int[] A) {
        if (A == null) {
            throw new NullPointerException();
        }
        int len = A.length;
        int i = -1, j = -1, k = -1;
        int backup = -1;

        int index;
        for (index = 0; index < len; index++) {
            if (i == -1) {
                i = index;
            } else if (j == -1) {
                if (A[index] > A[i]) {
                    j = index;
                } else {
                    i = index;
                }
            } else if (A[index] > A[j]) {
                k = index;
                break;
            } else if (A[index] < A[j]) {
                if (backup != -1) {
                    if (A[index] > A[backup]) {
                        i = backup;
                        j = index;
                        backup = -1;
                    } else if (A[index] < A[backup]) {
                        backup = index;
                    }
                } else {
                    backup = index;
                }
            }
        }
        if (index == len) {
            i = j = k = -1;
        }

        System.out.println(i + ", " + j + ", " + k);
    }

    public static void main(String[] args) {
        int[] A = {3,2,5,1,4,7,9,6,8};
        increasingIndex2(A);
    }
}
