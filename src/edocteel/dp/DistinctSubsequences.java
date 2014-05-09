package edocteel.dp;

/**
 * Created by chace on 5/8/14.
 */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        if (S == null || T == null) {
            return 0;
        }
        int[][] dp = new int[T.length()+1][S.length()+1];
        dp[0][0] = 1;
        for (int i = 1; i <= T.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= S.length(); i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= T.length(); i++) {
            for (int j = 1; j <= S.length(); j++) {
                dp[i][j] = dp[i][j-1];
                if (T.charAt(i-1) == S.charAt(j-1)) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }

        return dp[T.length()][S.length()];
    }

    public int numDistinct1(String S, String T) {
        if (S.length() == 0) {
            return T.length() == 0 ? 1 : 0;
        }
        if (T.length() == 0) {
            return 1;
        }
        int cnt = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == T.charAt(0)) {
                cnt += numDistinct1(S.substring(i+1), T.substring(1));
            }
        }
        return cnt;
    }
}
