package edocteel.dp;

/**
 * Created by chace on 5/4/14.
 */
public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;

        int[][] matrix = new int[rLen][cLen];
        matrix[rLen - 1][cLen - 1] = grid[rLen - 1][cLen - 1];

        for (int i = rLen - 2; i >= 0; i--) {
            matrix[i][cLen - 1] = grid[i][cLen - 1] + matrix[i+1][cLen - 1];
        }
        for (int i = cLen - 2; i >= 0; i--) {
            matrix[rLen - 1][i] = grid[rLen - 1][i] +  matrix[rLen - 1][i+1];
        }
        for (int i = rLen - 2; i >= 0; i--) {
            for (int j = cLen - 2; j >= 0; j--) {
                matrix[i][j] = grid[i][j] + Math.min(matrix[i+1][j], matrix[i][j+1]);
            }
        }
        return matrix[0][0];
    }

    public static int minPathSum2(int[][] grid) {
        int rL = grid.length;
        int cL = grid[0].length;
        int[][] matrix = new int[rL][cL];
        matrix[0][0] = grid[0][0];
        for (int i = 1; i < rL; i++) {
            matrix[i][0] = matrix[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < cL; i++) {
            matrix[0][i] = matrix[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < rL; i++) {
            for (int j = 1; j < cL; j++) {
                matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][j-1]) + grid[i][j];
            }
        }
        return matrix[rL-1][cL-1];
    }
    public static void main(String[] args) {
        minPathSum(new int[][]{{1,2,5},{3,2,1}});
    }
}
