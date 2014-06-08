package string;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by chace on 6/8/14.
 */
public class AllSubstring {

    public static ArrayList<String> allSubstring(String str, char[] dict) {
        ArrayList<String> results = new ArrayList<String>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 1; j <= str.length() - i; j++) {
                String sub = str.substring(i, i+j);
                if (sub.length() == 1) {
                    if ((i == 0 || !sub.equals(str.substring(i-1, i))) && !containsAll(sub, dict)) {
                        results.add(sub);
                    }
                } else if (!containsAll(sub, dict)){
                    results.add(sub);
                }
            }
        }
        return results;
    }

    public static ArrayList<String> allCombination(String str, char[] dict) {
        ArrayList<String> results = new ArrayList<String>();
        ArrayList<String> prev = new ArrayList<String>();
        results.add("");
        for (int i = 0; i < str.length(); i++) {
            ArrayList<String> tmp = new ArrayList<String>();
            ArrayList<String> p = i == 0 || str.charAt(i) != str.charAt(i-1) ? results : prev;
            for (String s : p) {
                String t = s + str.charAt(i);
                if (!containsAll(t, dict)) {
                    tmp.add(t);
                }
            }
            results.addAll(tmp);
            prev = tmp;
        }
        return results;
    }

    public static boolean containsAll(String str, char[] dict) {
        Hashtable<Character, Integer> map = new Hashtable<Character, Integer>();
        for (char c : dict) {
            int times = 0;
            if (map.containsKey(c)) {
                times = map.get(c);
            } else {
                times = 1;
            }
            map.put(c, times);
        }
        for (int i = 0; i < str.length(); i++) {
            char t = str.charAt(i);
            map.put(t, map.get(t) - 1);
        }
        for (Character c : map.keySet()) {
            if (map.get(c) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<String> results = allCombination("abbc", new char[] {'a', 'b', 'c'});
        for (String str : results) {
            System.out.println(str);
        }
    }
}
