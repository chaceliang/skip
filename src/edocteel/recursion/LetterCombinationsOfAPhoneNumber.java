package edocteel.recursion;

import java.util.ArrayList;

/**
 * Created by chace on 5/4/14.
 */
public class LetterCombinationsOfAPhoneNumber {
    public static String mappings[][] = {
            {"0"}, {"1"}, {"A", "B", "C"}, {"D", "E", "F"}, {"G", "H", "I"},
            {"J", "K", "L"}, {"M", "N", "O"}, {"P", "Q", "R", "S"},
            {"T", "U", "V"}, {"W", "X", "Y", "Z"}
    };

    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> results = new ArrayList<String>();
        if (digits.length() <= 0) {
            results.add("");
            return results;
        }
        solve(results, "", digits);
        return results;
    }

    public void solve(ArrayList<String> results, String prefix, String remaining) {
        int digit = Integer.parseInt(remaining.substring(0, 1));
        if (remaining.length() == 1) {
            for (int i = 0; i < mappings[digit].length; i++) {
                results.add(prefix + mappings[digit][i]);
            }
        } else {
            for (int i = 0; i < mappings[digit].length; i++) {
                solve(results, prefix + mappings[digit][i], remaining.substring(1));
            }
        }
    }
}
