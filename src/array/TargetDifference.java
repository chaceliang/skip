package array;

import java.util.Arrays;

/**
 * Created by chace on 5/26/14.
 */
public class TargetDifference {
    // array[i] - array[j] = k
    public static void targetDifference(int[] A, int k) {
        if (A == null || A.length <= 0) {
            return;
        }
        Arrays.sort(A);
        int i = 0, j = A.length - 1;
        while (i < j) {
            int tmp = A[j] - A[i];
            if (tmp == k) {
                System.out.println(i + " " + j);
                return;
            } else if (tmp > k) {
                j--;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,8};
        targetDifference(A, 3);
    }
}
