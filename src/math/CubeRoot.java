package math;

/**
 * Created by chace on 6/24/14.
 */
public class CubeRoot {
    public static int cubeRoot(int num) {
        boolean neg = false;
        if (num < 0) {
            neg = true;
            num = -num;
        }
        if (num == 0) {
            return 0;
        }
        int low = 1, high = num;
        if (num < 1) {
            low = num;
            high = 1;
        }
        while (true) {
            int mid = (low + high) / 2;
            long tmp = mid * mid * mid;
            if (tmp == num) {
                if (neg) {
                    mid = -mid;
                }
                return mid;
            } else if (tmp > num) {
                high = mid;
            } else {
                low = mid;
            }
        }
    }

    public static double cubeRoot(double num) {
        if (num == 0) {
            return 0;
        }
        boolean neg = false;
        if (num < 0) {
            neg = true;
            num = -num;
        }
        double low = 1, high = num;
        double e = 0.0000000001;
        if (num < 1) {
            low = num;
            high = 1;
        }
        while (true) {
            double mid = (low + high) / 2;
            double tmp = mid * mid * mid;
            if (tmp == num || Math.abs(mid - tmp) <= e || high - low <= 0) {
                if (neg) {
                    mid = -mid;
                }
                return mid;
            } else if (tmp > num) {
                high = mid;
            } else {
                low = mid;
            }
        }
    }
}
