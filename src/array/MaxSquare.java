package array;

/**
 * Created by chace on 5/24/14.
 */
public class MaxSquare {

    public static int maxSquare(int[][] A) {
        int max = 0;
        if (A == null || A.length <= 0 || A[0].length <= 0) {
            return max;
        }
        int m = A.length, n = A[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (A[i][j] == 0) {
                    dp[i][j] = 0;
                } else if ((i == m-1 || j == n-1) && A[i][j] == 1) {
                    dp[i][j] = 1;
                } else if (A[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i+1][j+1], dp[i+1][j]), dp[i][j+1]);
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}};
        System.out.println(maxSquare(A));
    }
}
