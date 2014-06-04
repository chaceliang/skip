package edocteel.miscellaneous;

/**
 * Created by chace on 6/3/14.
 */
public class ZigZagConversion {

    public static String convert(String s, int nRows) {
        if (nRows == 1) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        int n = nRows + nRows - 2;
        for (int i = 0; i < nRows; i++) {
            int cur = i;
            while (cur < s.length()) {
                builder.append(s.charAt(cur));
                cur += n;
                if (i > 0 && i < nRows - 1 && (cur - i - i) < s.length()) {
                    builder.append(s.charAt(cur-i-i));
                }
            }
        }
        return builder.toString();
    }
}
