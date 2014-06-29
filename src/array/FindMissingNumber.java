package array;

import java.util.ArrayList;

/**
 * Created by chace on 6/8/14.
 */
public class FindMissingNumber {

    public static ArrayList<Integer> findMissing(int[] A) {
        if (A == null) {
            throw new NullPointerException();
        }
        int i = 0;
        while (i < A.length) {
            if (A[i] != i && A[i] >= 0 && A[i] < A.length && A[A[i]] != A[i]) {
                swap(A, i, A[i]);
                continue;
            }
            i++;
        }

        ArrayList<Integer> missing = new ArrayList<Integer>();
        for (i = 1; i < A.length; i++) {
            if (A[i] != i) {
                missing.add(i);
            }
        }

        return missing;
    }

    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
