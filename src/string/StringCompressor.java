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

    public static String decompressor(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        StringBuilder builder = new StringBuilder();
        int i = 0, len = str.length();
        while (i < len) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if (i < len - 2 && str.charAt(i+1) == '*') {
                    int times = str.charAt(i) - '0';
                    char c = str.charAt(i+2);
                    while (times-- > 0) {
                        builder.append(c);
                    }
                    i += 2;
                } else {
                    builder.append(str.charAt(i));
                }
            } else {
                builder.append(str.charAt(i));
            }
            i++;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println("1223abkkkkkc");
        System.out.println(compressor("1223abkkkkkc*"));
        System.out.println(decompressor(compressor("1223abkkkkkc1*")));
    }
}
