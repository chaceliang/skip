package edocteel.dp;

/**
 * Created by chace on 5/14/14.
 */
public class EditDistance {
    // Each operation cost 1
    public static int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return -1;
        }
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]) + 1,
                        dp[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1));
            }
        }
        return dp[l1][l2];
    }

    // Insert cost 1, deletion cost 1, replace cost 2
    public int editDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1][l2];
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 2);
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("cat", "cast"));
    }
}
