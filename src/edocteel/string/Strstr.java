package edocteel.string;

/**
 * Created by chace on 5/15/14.
 */
public class Strstr {
    public String strStr(String haystack, String needle) {
        int i = 0;
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len1 == 0 && len2 == 0) {
            return "";
        }
        for (; i <= len1 - len2; i++) {
            int a = i;
            int b = 0;
            boolean match = true;
            while (b < len2) {
                if (a >= len1 || haystack.charAt(a) != needle.charAt(b)) {
                    match = false;
                    break;
                } else {
                    a++;
                    b++;
                }
            }
            if (match) {
                return haystack.substring(i);
            }
        }
        return null;
    }
}
