package string;

/**
 * Created by chace on 6/3/14.
 */
public class BriefMatch {

    public static boolean isMatch(String str, String brief) {
        int i = 0, j = 0;
        int m = str.length(), n = brief.length();
        int num = 0;
        while (i < m && j < n) {
            if (isNumber(brief.charAt(j))) {
                while (j < n && isNumber(brief.charAt(j))) {
                    num = num * 10 + (brief.charAt(j) - '0');
                    j++;
                }
                int oldI = i;
                while (i < m && i < i + num) {
                    i++;
                    num--;
                }
                if (num > 0) {
                    break;
                }
            } else {
                if (str.charAt(i) != brief.charAt(j)) {
                    break;
                }
                i++; j++;
            }
        }
        return i == m && j == n && num == 0;
    }

    public static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        System.out.println(isMatch("abcd", "a2d"));
        System.out.println(isMatch("abcd", "a1cd"));
        System.out.println(isMatch("abcd", "3d"));
        System.out.println(isMatch("abcd", "4"));
        System.out.println(isMatch("abcd", "5"));
        System.out.println(isMatch("abcd", "3"));
    }
}
