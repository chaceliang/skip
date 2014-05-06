package edocteel.dp;

/**
 * Created by chace on 5/6/14.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int s1L = s1.length(), s2L = s2.length();

        boolean[][] dp = new boolean[s1L+1][s2L+1];
        dp[0][0] = true;

        for (int i = 1; i <= s1L; i++) {
            dp[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1)) && dp[i-1][0];
        }
        for (int i = 1; i <= s2L; i++) {
            dp[0][i] = (s2.charAt(i - 1) == s3.charAt(i - 1)) && dp[0][i-1];
        }
        for (int i = 1; i <= s1L; i++) {
            for (int j = 1; j <= s2L; j++) {
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        return dp[s1L][s2L];
    }
}
