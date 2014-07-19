package dp;

/**
 * Created by chace on 5/28/14.
 */
public class MaxSum {

    public static int maxSum(int[] A) {
        if (A == null || A.length <= 0) {
            return 0;
        }
        int len = A.length;
        int[] maxSum = new int[len];
        int level = 1;
        for (int i = 0; i + level <= len;) {
            int j = i;
            int[] tmp = new int[len];
            tmp[0] = A[j] + (level > 1 ? maxSum[0] : 0);
            for (j = j+1; j < i+level-1; j++) {
                tmp[j-i] = Math.max(maxSum[j-i-1], maxSum[j-i]) + A[j];
            }
            tmp[level-1] = A[i+level-1] + (level > 1 ? maxSum[level-2] : 0);
            i += level;
            level++;
            maxSum = tmp;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (maxSum[i] > max) {
                max = maxSum[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{11,9,12,4,8,6,2,7,3,1}));
    }
}
