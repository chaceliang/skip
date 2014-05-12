package edocteel.miscellaneous;

/**
 * Created by chace on 5/12/14.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int length = matrix.length;
        if (length <= 0) {
            return;
        }
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][length-j-1];
                matrix[i][length-j-1] = tmp;
            }
        }
    }
}
