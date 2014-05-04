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

    public static void main(String[] args) {
        minPathSum(new int[][]{{1,2,5},{3,2,1}});
    }
}
