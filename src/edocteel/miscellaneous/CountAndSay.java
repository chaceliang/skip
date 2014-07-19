package edocteel.miscellaneous;

/**
 * Created by chace on 5/4/14.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String num = "1";
        for (int i = 1; i < n; i++) {
            num = countAndSay(num);
        }
        return num;
    }

    public String countAndSay(String n) {
        int times = 1;
        char repeat = n.charAt(0);
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < n.length(); i++) {
            char c = n.charAt(i);
            if (c == repeat) {
                times++;
            } else {
                result.append(times);
                result.append(repeat);
                repeat = c;
                times = 1;
            }
        }
        result.append(times);
        result.append(repeat);
        return result.toString();
    }

    public static void main(String[] args) {
        CountAndSay test = new CountAndSay();
        test.countAndSay(3);
    }
}
