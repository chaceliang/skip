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

    public int numDistinctR(String S, String T) {
        return numSubseq(S, T, S.length() - 1, T.length() - 1);
    }

    private int numSubseq(String S, String T, int si, int ti) {
        if (si < 0 || ti < 0 || si < ti) return 0;

        if (S.charAt(si) == T.charAt(ti)) {
            if (ti == 0) {
                return numSubseq(S, T, si - 1, ti) + 1;
            } else {
                return numSubseq(S, T, si - 1 , ti) + numSubseq(S, T, si - 1, ti - 1);
            }
        }
        return numSubseq(S, T, si - 1, ti);
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
