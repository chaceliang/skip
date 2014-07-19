package edocteel.miscellaneous;

/**
 * Created by chace on 5/4/14.
 */
public class ValidPalindrome {

    public boolean isAlphabet(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        s = s.toLowerCase();
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            if (!isAlphabet(s.charAt(start))) {
                start++;
            } else if (!isAlphabet(s.charAt(end))) {
                end--;
            } else if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}
