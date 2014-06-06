package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chace on 6/6/14.
 */
public class ConvertStringToArrayBySpace {
    // a b cde "f g""h j" => [a, b, cde, 'f g', 'h j’]

    public static List<String> stringToArray(String input) {
        if (input == null || input.length() <= 0) {
            return null;
        }
        ArrayList<String> tmpResult = new ArrayList<String>();
        int i = 0, len = input.length();
        StringBuilder tmp = new StringBuilder();
        boolean hasQuote = false;
        while (i < len) {
            char t = input.charAt(i);
            if (t == ' ') {
                if (hasQuote) {
                    tmp.append(t);
                } else {
                    tmpResult.add(tmp.toString());
                    tmp = new StringBuilder();
                }
            } else if (t == '"') {
                if (hasQuote) {
                    tmpResult.add(tmp.toString());
                    tmp = new StringBuilder();
                    hasQuote = false;
                } else {
                    hasQuote = true;
                }
            } else {
                tmp.append(t);
            }
            i++;
        }
        if (tmp.length() > 0) {
            tmpResult.add(tmp.toString());
        }
        return tmpResult;
    }

    public static void main(String[] args) {
        String input = "a b cde \"f g\"\"h j\"";
        List<String> result = stringToArray(input);
        for (String str : result) {
            System.out.println(str);
        }
    }
}
