package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by chace on 5/26/14.
 */
public class IntersectionOfTwoArrays {

    // Sorted
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

    // Unsorted Handle duplicate
    public static ArrayList<Integer> intersection2(int[] A, int[] B) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }

        for (int i = 0; i < B.length; i++) {
            if (map.containsKey(B[i]) && map.get(B[i]) > 0) {
                results.add(B[i]);
                map.put(B[i], map.get(B[i]) - 1);
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
