package edocteel.miscellaneous;

/**
 * Created by chace on 5/4/14.
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int len = 0;
        while ((int)(x/Math.pow(10, len)) != 0) {
            len++;
        }

        for (int i = 0; i < len/2; i++) {
            if ((int)(x/Math.pow(10, i)) % 10 != (int)(x/Math.pow(10, len - 1 - i)) % 10) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isPalindrome(2147483647);
    }
}
