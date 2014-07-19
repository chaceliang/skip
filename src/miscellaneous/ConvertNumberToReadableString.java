package miscellaneous;

/**
 * Created by chace on 6/7/14.
 */
public class ConvertNumberToReadableString {

    static String[] suffix = {"", "Thousand", "Million", "Billion", "Trillion"};
    static String[] NUM = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    static String[] TEN = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static String[] UNDER_TWENTY = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    public static String convert(int num) {
        int partNum = 0;
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            int part = num % 1000;
            num /= 1000;
            if (part > 0) {
                StringBuilder tmp = new StringBuilder();
                tmp.append(convert3Digits(part));
                if (partNum > 0) {
                    tmp.append(" ");
                }
                tmp.append(suffix[partNum]);
                if (partNum > 0) {
                    tmp.append(" ");
                }
                builder.insert(0, tmp.toString());
            }
            partNum++;
        }
        return builder.toString();
    }

    public static String convert3Digits(int num) {
        StringBuilder builder = new StringBuilder();
        if (num >= 100) {
            int hundredNum = num / 100;
            num = num % 100;
            builder.append(NUM[hundredNum]);
            builder.append(" Hundred");
        }
        if (builder.length() > 0 && num > 0) {
            builder.append(" ");
        }
        if (num >= 20) {
            int tenNum = num / 10;
            num = num % 10;
            builder.append(TEN[tenNum]);
            if (num > 0) {
                builder.append(" " + NUM[num]);
            }
        } else if (num >= 10) {
            builder.append(UNDER_TWENTY[num - 10]);
        } else if (num > 0) {
            builder.append(NUM[num]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        for (int i = 9000000; i < 10000000; i++) {
            System.out.println(convert(i));
        }
    }
}
