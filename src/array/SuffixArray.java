package array;

import java.util.Arrays;

/**
 * Created by chace on 6/7/14.
 */
public class SuffixArray {

    public static int[] buildSuffixArray(String str) {
        Suffix[] suffixes = new Suffix[str.length()];
        for (int i = 0; i < str.length(); i++) {
            Suffix suffix = new Suffix();
            suffix.index = i;
            suffix.stuff = str.substring(i);
            suffixes[i] = suffix;
        }

        Arrays.sort(suffixes);

        int[] suffixArray = new int[str.length()];
        for (int i = 0; i < suffixes.length; i++) {
            suffixArray[i] = suffixes[i].index;
        }
        return suffixArray;
    }

    public static void main(String[] args) {
        int[] result = buildSuffixArray("banana");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

class Suffix implements Comparable<Suffix> {
    int index;
    String stuff;

    @Override
    public int compareTo(Suffix suffix) {
        return this.stuff.compareTo(suffix.stuff);
    }
}