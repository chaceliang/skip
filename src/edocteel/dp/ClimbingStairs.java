package edocteel.dp;

/**
 * Created by chace on 5/4/14.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] result = new int[n+1];
        for (int i = 0; i <= n; i++) {
            if (i <= 2) {
                result[i] = i;
            } else {
                result[i] = result[i-1] + result[i-2];
            }
        }
        return result[n];
    }
}
