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
        n = n.substring(1) + " "; // in case n is empty string after substring
        StringBuilder result = new StringBuilder();
        for (char c : n.toCharArray()) {
            if (c == repeat) {
                times++;
            } else {
                result.append(times);
                result.append(repeat);
                repeat = c;
                times = 1;
            }
        }
        return result.toString();
    }
}
