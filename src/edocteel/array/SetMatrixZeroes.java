package edocteel.array;

/**
 * Created by chace on 5/4/14.
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean shouldSetFirstRow = false;
        boolean shouldSetFirstCol = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                shouldSetFirstCol = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                shouldSetFirstRow = true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (shouldSetFirstCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (shouldSetFirstRow) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes test = new SetMatrixZeroes();
        test.setZeroes(new int[][] {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}});
    }
}
