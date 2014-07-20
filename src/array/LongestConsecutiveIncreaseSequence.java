package array;

/**
 * Created by Chace on 7/19/14.
 */
public class LongestConsecutiveIncreaseSequence {
    /*
    最长的连续递增子序列。所有元素是相邻的
     */

    public static int lis(int[] A) {
        if (A == null) {
            throw new NullPointerException();
        }
        int len = A.length;
        if (len <= 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cmax = 1;

        for (int i = 1; i < len; i++) {
            if (A[i] > A[i-1]) {
                cmax++;
            } else {
                max = Math.max(cmax, max);
                cmax = 1;
            }
        }
        max = Math.max(cmax, max);
        return max;
    }

    public static void main(String[] args) {
        int[] A1 = {1,2,3,4,5,6};
        int[] A2 = {6,5,4,3,2,1};
        int[] A3 = {1,2,4,3,5,6};

        System.out.println(lis(A1));
        System.out.println(lis(A2));
        System.out.println(lis(A3));
    }
}
