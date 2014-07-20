package string;

/**
 * Created by chace on 6/6/14.
 */
public class StringCompressor {

    // Google onsite.
    // String compressor that turns "123abkkkkkc" to "123ab5xkc".
    // Decompressor is already written and must remain unchanged.
    // take into account of strings like: "123xk", "123xx" ...etc as input

    public static String compressor(String s) {
        StringBuilder builder = new StringBuilder();

        int i = 0, len = s.length();
        while (i < len) {
            int times = 1;
            int j = i+1;
            while (j < len) {
                if (s.charAt(i) == s.charAt(j)) {
                    j++; times++;
                } else {
                    break;
                }
            }
            if (s.charAt(i) == '*' && i != len-1 && times == 1) {
                builder.append("1**");
            } else {
                if (times > 1) {
                    builder.append(times);
                    builder.append("*");
                }
                builder.append(s.charAt(i));
            }
            i = j;
        }

        return builder.toString();
    }

    public static String decompressor(String s) {
        StringBuilder builder = new StringBuilder();
        int i = 0, len = s.length();
        while (i < len) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if (i < len - 2 && s.charAt(i+1) == '*') {
                    int times = s.charAt(i) - '0';
                    char c = s.charAt(i+2);
                    while (times-- >= 0) {
                        builder.append(c);
                    }
                    i += 2;
                }
            } else {
                builder.append(s.charAt(i));
            }
            i++;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println("1223abkkkkkc");
        System.out.println(compressor("1223abkkkkk*c*"));
        System.out.println(decompressor(compressor("1223abkkkkkc1*")));
    }
}
