package edocteel.miscellaneous;

/**
 * Created by chace on 5/4/14.
 */
public class StringToInt {
    public static int atoi(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        boolean hasNegative = false;
        int i = 0;
        boolean didStart = false;
        long result = 0;
        while (i < str.length()) {
            if (str.charAt(i) != ' ') {
                didStart = true;
                break;
            }
            i++;
        }
        if (!didStart) {
            return 0;
        }
        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            hasNegative = true;
            i++;
        }
        while (i < str.length()) {
            char s = str.charAt(i++);
            if (s >= '0' && s <= '9') {
                result = result * 10 + (s - '0');
            } else {
                break;
            }
            if (result > Integer.MAX_VALUE && !hasNegative) {
                return Integer.MAX_VALUE;
            } else if (result > 2147483648.0 && hasNegative) {
                return Integer.MIN_VALUE;
            }
        }
        if (hasNegative) {
            result *= -1;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        atoi("-1");
    }
}
