package edocteel.dp;

/**
 * Created by chace on 5/10/14.
 */
public class JumpGameII {
    public int jump(int[] A) {
        int start = 0, end = 0, count = 0;
        if (A == null || A.length <= 1) {
            return 0;
        }
        int length = A.length;
        while (end < length) {
            int max = 0;
            count++;
            for (int i = start; i <= end; i++) {
                if (A[i] + i >= length - 1) {
                    return count;
                }
                if (A[i] + i > max) {
                    max = A[i] + i;
                }
            }
            start = end + 1;
            end = max;
        }
        return -1;
    }
}
