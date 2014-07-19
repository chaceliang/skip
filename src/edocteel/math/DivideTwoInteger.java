package edocteel.math;

/**
 * Created by chace on 5/15/14.
 */
public class DivideTwoInteger {
    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException();
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

    public static int mod(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException();
        }
        long a = dividend, b = divisor;
        boolean neg = false;
        if (a < 0) {
            a = Math.abs(a);
            neg = !neg;
        }
        if (b < 0) {
            b = Math.abs(b);
            neg = !neg;
        }

        int count = 0;
        while (b << count < a) {
            count++;
        }

        while (count >= 0) {
            if (b << count <= a) {
                a -= b << count;
            }
            count--;
        }
        return (int)a;
    }

    public static void main(String[] args) {
        System.out.println(mod(5, 2));
    }
}
