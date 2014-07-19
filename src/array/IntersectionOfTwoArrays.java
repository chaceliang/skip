package array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by chace on 5/26/14.
 */
public class IntersectionOfTwoArrays {

    public static ArrayList<Integer> intersection(int[] A, int[] B) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        Arrays.sort(A);
        Arrays.sort(B);
        int m = A.length, n = B.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (A[i] == B[j]) {
                results.add(A[i]);
                i++; j++;
            } else if (A[i] > B[j]) {
                j++;
            } else {
                i++;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        results = intersection(new int[]{1,2,3,4,5,6}, new int[]{3,4,5,9,10});
        for (Integer i : results) {
            System.out.print(i + " ");
        }
    }
}
