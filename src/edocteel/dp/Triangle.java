package edocteel.dp;

import java.util.ArrayList;

/**
 * Created by chace on 5/6/14.
 */
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() <= 0) {
            return 0;
        }
        int rows = triangle.size();
        int[] minSum = new int[rows];
        for (int i = 0; i < rows; i++) {
            int[] tmp = new int[rows];
            ArrayList<Integer> level = triangle.get(i);
            if (level.size() != i+1) {
                return -1; // Wrong input
            }
            tmp[0] = level.get(0) +((i > 0) ? minSum[0] : 0);
            for (int j = 1; j < i; j++) {
                tmp[j] = Math.min(minSum[j-1], minSum[j]) + level.get(j);
            }
            tmp[i] = level.get(i) + (i > 0 ? minSum[i - 1] : 0);

            minSum = tmp;
        }
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < rows; k++) {
            if (minSum[k] < min) {
                min = minSum[k];
            }
        }
        return min;
    }
}
