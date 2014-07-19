package string;

/**
 * Created by chace on 6/11/14.
 */
public class StringCompare {

    public static int compare(String a, String b) {
        if (a == null || b == null) {
            if (a == null && b == null) {
                return 0;
            } else if (a == null) {
                return -1;
            } else {
                return 1;
            }
        }
        int i = 0, j = 0, la = a.length(), lb = b.length();
        while (i < la && j < lb) {
            if (a.charAt(i) > b.charAt(j)) {
                return 1;
            } else if (a.charAt(i) < b.charAt(j)) {
                return -1;
            } else {
                i++;
                j++;
            }
        }
        if (i == la && j == lb) {
            return 0;
        }
        return i == la ? -1 : 1;
    }

    public static void main(String[] args) {
        System.out.println(compare("ab", "a"));
        System.out.println(compare("ab", "ab"));
        System.out.println(compare("ab", "abc"));
    }
}
