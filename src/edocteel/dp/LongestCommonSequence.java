package edocteel.dp;

/**
 * Created by chace on 5/14/14.
 */
public class LongestCommonSequence {

    public int lcs(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return -1;
        }
        StringBuilder builder = new StringBuilder();
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    builder.append(word1.charAt(i-1));
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    if (dp[i-1][j] > dp[i][j-1]) {
                        builder.append(word1.charAt(i-2));
                    } else {
                        builder.append(word2.charAt(j-2));
                    }
                }
            }
        }
        return dp[l1][l2];
    }
}
