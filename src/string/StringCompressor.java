package string;

/**
 * Created by chace on 6/6/14.
 */
public class StringCompressor {
    // 123abkkkkkc => 123ab5xkc

    public static String compressor(String str) {
        if (str == null || str.length() <= 0) {
            return str;
        }
        int i = 0, len = str.length();
        StringBuilder builder = new StringBuilder();
        while (i < len) {
            int times = 1;
            int j = i + 1;
            while (j < len) {
                if (str.charAt(j) == str.charAt(i)) {
                    j++;
                    times++;
                } else {
                    break;
                }
            }
            if (times > 1) {
                builder.append(times);
                builder.append("*");
            }
            builder.append(str.charAt(i));
            i = j;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressor("123abkkkkkc"));
    }
}
