package edocteel.miscellaneous;

/**
 * Created by chace on 5/4/14.
 */
public class ReverseInteger {
    public int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x *= -1;
        }
        int result = 0;
        while (x > 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (isNegative) {
            result *= -1;
        }
        return result;
    }

    public static int reverse2(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x *= -1;
        }
        long result = 0;
        while (x > 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (isNegative) {
            result *= -1;
        }
        if (result < Integer.MAX_VALUE && result > Integer.MIN_VALUE) {
            return (int)result;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(reverse2(23456789));
        System.out.println(reverse2(456789));
        System.out.println(reverse2(-123456789));
    }
}
