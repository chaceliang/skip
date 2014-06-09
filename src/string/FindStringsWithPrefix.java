package string;

import java.util.Arrays;

/**
 * Created by chace on 6/8/14.
 */
public class FindStringsWithPrefix {

    public static String[] findStringsWithPrefix(String[] input, String prefix) {
        // Find first appear
        int i = 0, j = input.length - 1;
        int lower = 0, higher = 0;
        while (i < j) {
            int mid = (i + j) / 2;
            String sub = null;
            if (input[mid].length() >= prefix.length()) {
                sub = input[mid].substring(0, prefix.length());
            } else {
                sub = input[mid];
            }

            if (sub.compareTo(prefix) >= 0) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        lower = i;
        if (input[lower].length() < prefix.length() || input[lower].substring(0, prefix.length()).compareTo(prefix) != 0) {
            return null;
        }
        i = 0;
        j = input.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            String sub = null;
            if (input[mid].length() >= prefix.length()) {
                sub = input[mid].substring(0, prefix.length());
            } else {
                sub = input[mid];
            }
            if (sub.compareTo(prefix) <= 0) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        higher = i;

        return Arrays.copyOfRange(input, lower, higher+1);
    }

    public static void main(String[] args) {
        String[] words = new String[20];
        for (int i = 0; i < 5; i++) {
            words[i] = "a";
        }
        for (int i = 5; i < 14; i++) {
            words[i] = "abc" + Integer.toString(i);
        }
        for (int i = 14; i < 20; i++) {
            words[i] = "bbbbb";
        }

        String[] results = findStringsWithPrefix(words, "abc");
        if (results == null) {
            System.out.println("Not found");
            return;
        }
        for (String str : results) {
            System.out.println(str);
        }
    }
}
