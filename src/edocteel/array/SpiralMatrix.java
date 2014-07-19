package edocteel.array;

import java.util.ArrayList;

/**
 * Created by chace on 5/4/14.
 */
public class SpiralMatrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return result;
        }
        int startX = 0, endX = matrix[0].length - 1;
        int startY = 0, endY = matrix.length - 1;

        while (shouldContinue(startX, endX, startY, endY)) {
            for (int i = startX; i <= endX; i++) {
                result.add(matrix[startY][i]);
            }
            startY++;
            if (!shouldContinue(startX, endX, startY, endY)) {
                break;
            }
            for (int i = startY; i <= endY; i++) {
                result.add(matrix[i][endX]);
            }
            endX--;
            if (!shouldContinue(startX, endX, startY, endY)) {
                break;
            }
            for (int i = endX; i >= startX; i--) {
                result.add(matrix[endY][i]);
            }
            endY--;
            if (!shouldContinue(startX, endX, startY, endY)) {
                break;
            }
            for (int i = endY; i >= startY; i--) {
                result.add(matrix[i][startX]);
            }
            startX++;
        }
        return result;
    }

    public boolean shouldContinue(int startX, int endX, int startY, int endY) {
        return startX <= endX && startY <= endY;
    }
}
