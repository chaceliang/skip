package edocteel.string;

/**
 * Created by chace on 5/15/14.
 */
public class Strstr {
    public String strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len1 == 0 && len2 == 0) {
            return "";
        }
        for (int i = 0; i <= len1 - len2; i++) {
            int a = i;
            int b = 0;
            while (b < len2) {
                if (haystack.charAt(a) != needle.charAt(b)) {
                    break;
                } else {
                    a++;
                    b++;
                }
            }
            if (b == len2) {
                return haystack.substring(i);
            }
        }
        return null;
    }
}
