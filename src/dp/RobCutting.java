package dp;

/**
 * Created by chace on 6/7/14.
 */
public class RobCutting {

    public static int cutRob(int[] prices) {
        int n = prices.length;
        int[] val = new int[n+1];
        val[0] = 0;
        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, prices[j] + val[i-j-1]);
            }
            val[i] = max;
        }
        return val[n];
    }
}
