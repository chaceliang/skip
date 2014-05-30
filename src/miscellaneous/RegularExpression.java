package miscellaneous;

/**
 * Created by chace on 5/27/14.
 */
public class RegularExpression {

    public static boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    public static boolean isMatch(String s, int i, String p, int j) {
        if (j == p.length()) {
            return i == s.length();
        }
        if (j == p.length() - 1 || (p.charAt(j+1) != '*' && p.charAt(j+1) != '+')) {
            if (i == s.length()) {
                return false;
            }
            return (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) && isMatch(s, i+1, p, j+1);
        }
        while (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')) {
            if (p.charAt(j+1) == '*') {
                if (isMatch(s, i, p, j+2)) {
                    return true;
                }
            }
            if (p.charAt(j+1) == '+') {
                if (isMatch(s, i+1, p, j+2)) {
                    return true;
                }
            }
            i++;
        }
        if (p.charAt(j+1) == '*') {
            return isMatch(s, i, p, j+2);
        } else {
            return isMatch(s, i+1, p, j+2);
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch("abc", "a+bc"));
        System.out.println(isMatch("abc", "a+.*bc"));
        System.out.println(isMatch("abc", "a+.*b"));
    }
}
