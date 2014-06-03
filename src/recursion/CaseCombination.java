package recursion;

import java.util.ArrayList;

/**
 * Created by chace on 6/3/14.
 */
public class CaseCombination {

    public static ArrayList<String> caseCombination(String s) {
        ArrayList<String> results = new ArrayList<String>();
        if (s == null || s.length() <= 0) {
            return results;
        }
        caseCombination(results, s.toLowerCase().toCharArray(), 0);
        return results;
    }

    public static void caseCombination(ArrayList<String> results, char[] sa, int index) {
        if (index == sa.length) {
            results.add(new String(sa));
            return;
        }
        caseCombination(results, sa, index + 1);
        char t = sa[index];
        sa[index] = Character.toUpperCase(t);
        caseCombination(results, sa, index + 1);
        sa[index] = t;
    }

    public static void main(String[] args) {
        String aa = "abc";
        ArrayList<String> results = caseCombination(aa);
        for (String s : results) {
            System.out.println(s);
        }
    }
}
