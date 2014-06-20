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
        for (int i = 0; i < A.length; i++) {
            while (A[i] - 1 >= 0 && A[i] - 1 < A.length && A[i] != A[A[i] - 1]) {
                swap(A, i, A[i] - 1);
            }
        }
        ArrayList<Integer> missing = new ArrayList<Integer>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i+1) {
                missing.add(i+1);
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
