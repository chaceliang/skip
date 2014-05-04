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
}
