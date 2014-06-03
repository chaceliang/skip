package string;

import java.util.ArrayList;

/**
 * Created by chace on 5/24/14.
 */
public class FindStringCombinations {
    // ab => ab, Ab, aB, AB

    public static ArrayList<String> combinations(String s) {
        ArrayList<String> results = new ArrayList<String>();
        if (s == null || s.length() <= 0) {
            return results;
        }
        helper(results, 0, s, new StringBuilder());
        return results;
    }

    public static void helper(ArrayList<String> results, int index, String s, StringBuilder builder) {
        if (index == s.length()) {
            results.add(builder.toString());
            return;
        }
        char l = s.toLowerCase().charAt(index);
        char u = s.toUpperCase().charAt(index);
        helper(results, index+1, s, builder.append(l));
        builder.setLength(builder.length() - 1);
        helper(results, index+1, s, builder.append(u));
        builder.setLength(builder.length() - 1);
    }

    public static void main(String[] args) {
        ArrayList<String> results = combinations("abc");
        for (String s : results) {
            System.out.println(s);
        }
    }

}
