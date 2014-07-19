package recursion;

import java.util.ArrayList;

/**
 * Created by chace on 5/26/14.
 */
public class CombinationStars {

    // Given a string with 0, 1, *
    // Convert all * into 0 or 1

    public ArrayList<String> combinationStars(String s) {
        ArrayList<String> results = new ArrayList<String>();
        if (s == null) {
            return results;
        }
        helper(results, "", s, 0);
        return results;
    }

    public void helper(ArrayList<String> results, String result, String s, int index) {
        if (index == s.length()) {
            results.add(new String(result));
            return;
        }
        if (s.charAt(index) == '*') {
            helper(results, result + '0', s, index+1);
            helper(results, result + '1', s, index+1);
        } else {
            helper(results, result + s.charAt(index), s, index+1);
        }
    }

    public static void main(String[] args) {
        CombinationStars test = new CombinationStars();
        ArrayList<String> results = test.combinationStars("00*1*0");
        for (String s : results) {
            System.out.println(s);
        }
    }

}
