package edocteel.dp;

/**
 * Created by chace on 5/4/14.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m < 0 || n < 0) {
            return -1;
        }
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            matrix[i][n-1] = 1;
        }
        for (int i = 0; i < n; i++) {
            matrix[m-1][i] = 1;
        }
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                matrix[i][j] = matrix[i+1][j] + matrix[i][j+1];
            }
        }
        return matrix[0][0];
    }
}
