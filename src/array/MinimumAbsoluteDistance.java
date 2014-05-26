package array;

/**
 * Created by chace on 5/25/14.
 */
public class MinimumAbsoluteDistance {

    public int getMinDistance(int[] x, int[] y) {
        int xi = 0, yi = 0;
        int minimum = Integer.MAX_VALUE;
        int m = x.length, n = y.length;
        while (xi < m && yi < n) {
            if (x[xi] >= y[yi]) {
                minimum = Math.min(minimum, x[xi] - y[yi]);
                yi++;
            } else {
                minimum = Math.min(minimum, y[yi] - x[xi]);
                xi++;
            }
        }
        return minimum;
    }
}
