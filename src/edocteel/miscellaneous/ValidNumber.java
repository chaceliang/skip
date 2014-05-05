package edocteel.miscellaneous;

/**
 * Created by chace on 5/4/14.
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null || s.length() < 0) {
            return false;
        }
        // Handle heading and tail space
        int start = 0, end = s.length() - 1;
        while (start < s.length()) {
            if (s.charAt(start) == ' ') {
                start++;
            } else {
                break;
            }
        }
        if (start == s.length()) {
            return false;
        }
        while (start <= end) {
            if (s.charAt(end) == ' ') {
                end--;
            } else {
                break;
            }
        }
        if (s.charAt(start) == '+' || s.charAt(start) == '-') {
            start++;
        }
        boolean isNum = false;
        boolean isDot = false;
        boolean isE = false;
        while (start <= end) {
            char c = s.charAt(start);
            if (c >= '0' && c <= '9') {
                isNum = true;
            } else if (c == '.') {
                if (isDot || isE) {
                    return false;
                } else {
                    isDot = true;
                }
            } else if (c == 'e') {
                if (isE || !isNum) {
                    return false;
                } else {
                    isE = true;
                    isNum = false;
                }
            } else if (c == '+' || c == '-') {
                if (s.charAt(start - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
            start++;
        }
        return isNum;
    }
}
