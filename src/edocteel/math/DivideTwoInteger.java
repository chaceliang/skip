package edocteel.math;

/**
 * Created by chace on 5/15/14.
 */
public class DivideTwoInteger {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return -1;
        }
        long a = dividend, b = divisor;
        boolean neg = false;
        if (a < 0) {
            neg = !neg;
            a = Math.abs(a);
        }
        if (b < 0) {
            neg = !neg;
            b = Math.abs(b);
        }
        int count = 0;
        while (b << count <= a) {
            count++;
        }
        int ans = 0;
        while (count >= 0) {
            if (b << count <= a) {
                a -= b << count;
                ans |= 1 << count;
            }
            count--;
        }
        return neg ? -ans : ans;
    }
}
