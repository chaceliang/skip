package edocteel.math;

/**
 * Created by chace on 5/4/14.
 */
public class Pow {
    public double pow(double x, int n) {
        double result = 1;
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        while (n > 0) {
            if (n % 2 == 0) {
                x *= x;
                n /= 2;
            } else {
                result *= x;
                n--;
            }
        }

        return result;
    }
}
