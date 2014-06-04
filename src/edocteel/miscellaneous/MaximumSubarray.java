package edocteel.miscellaneous;

/**
 * Created by chace on 5/9/14.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        if (A == null || A.length <= 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;

        int maxNeg = Integer.MIN_VALUE;
        boolean isAllNeg = true;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                isAllNeg = false;
            } else {
                if (A[i] > maxNeg) {
                    maxNeg = A[i];
                }
            }
        }
        if (isAllNeg) {
            return maxNeg;
        }
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum < 0) {
                sum = 0;
            } else if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public int maxSubArrayDP(int[] A) {
        if (A == null || A.length <= 0) {
            return 0;
        }
        int maxSoFar = A[0], i;
        int curMax = A[0];
        for (i = 1; i < A.length; i++) {
            curMax = Math.max(A[i], curMax + A[i]);
            maxSoFar = Math.max(maxSoFar, curMax);
        }
        return maxSoFar;
    }
}
