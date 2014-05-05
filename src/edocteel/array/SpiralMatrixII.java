package edocteel.array;

/**
 * Created by chace on 5/4/14.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int startX = 0, endX = n - 1;
        int startY = 0, endY = n - 1;

        int counter = 1;
        while (shouldContinue(startX, endX, startY, endY)) {
            for (int i = startX; i <= endX; i++) {
                matrix[startY][i] = counter++;
            }
            startY++;
            if (!shouldContinue(startX, endX, startY, endY)) {
                break;
            }
            for (int i = startY; i <= endY; i++) {
                matrix[i][endX] = counter++;
            }
            endX--;
            if (!shouldContinue(startX, endX, startY, endY)) {
                break;
            }
            for (int i = endX; i >= startX; i--) {
                matrix[endY][i] = counter++;
            }
            endY--;
            if (!shouldContinue(startX, endX, startY, endY)) {
                break;
            }
            for (int i = endY; i >= startY; i--) {
                matrix[i][startX] = counter++;
            }
            startX++;
        }
        return matrix;
    }

    public boolean shouldContinue(int startX, int endX, int startY, int endY) {
        return startX <= endX && startY <= endY;
    }
}
