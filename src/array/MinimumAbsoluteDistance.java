package array;

import java.util.Hashtable;

/**
 * Created by chace on 5/25/14.
 */
public class MinimumAbsoluteDistance {

    public int getMinDistance(int[] x, int[] y) {
        int xi = 0, yi = 0;
        int minimum = Integer.MAX_VALUE;
        int m = x.length, n = y.length;
        while (xi < m && yi < n) {
            minimum = Math.min(minimum, Math.abs(x[xi] - y[yi]));
            if (x[xi] >= y[yi]) {
                yi++;
            } else {
                xi++;
            }
        }
        return minimum;
    }
}
