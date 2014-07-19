package dp;

/**
 * Created by chace on 5/22/14.
 */
public class LongestIncreaseSequence {
    public int lis(int[] A) {
        if (A == null || A.length <= 0) {
            return 0;
        }
        int len = A.length;
        int[] lis = new int[len];
        for (int i = 0; i < len; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        int max = 0;
        for (int k = 0; k < len; k++) {
            if (lis[k] > max) {
                max = lis[k];
            }
        }
        return max;
    }
}
