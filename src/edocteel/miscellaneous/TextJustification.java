package edocteel.miscellaneous;

import java.util.ArrayList;

/**
 * Created by chace on 5/16/14.
 */
public class TextJustification {

    public static ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> results = new ArrayList<String>();
        int length = words.length;
        if (length == 0) {
            return results;
        }
        int start = 0, end = 0;
        int len = 0;
        while (start < length) {
            StringBuilder builder = new StringBuilder();
            while (end < length) {
                int s1 = words[end].length();
                if (len + (end - start) + s1 > L) {
                    break;
                }
                len += s1;
                end++;
            }
            end--;
            if (end < start) {
                end = start;
            }
            if (start == end) {
                builder.append(words[start]);
                int spaceCount = L - words[start].length();
                for (int i = 0; i < spaceCount; i++) {
                    builder.append(" ");
                }
            } else {
                boolean lastLine = end == length - 1;
                int spaceBase = lastLine ? 1 : (L - len) / (end - start);
                int bonus = lastLine ? 0 : (L - len - spaceBase * (end - start));
                builder.append(words[start]);
                for (int i = start+1; i <= end; i++) {
                    for (int j = 0; j < spaceBase; j++) {
                        builder.append(" ");
                    }
                    if (bonus > 0) {
                        builder.append(" ");
                        bonus--;
                    }
                    builder.append(words[i]);
                }
                if (lastLine) {
                    for (int i = 0; i < L - len - (end - start); i++) {
                        builder.append(" ");
                    }
                }
            }
            results.add(builder.toString());

            start = end + 1;
            end = start;
            len = 0;
        }

        return results;
    }

    public static void main(String[] args) {
        String[] A = {"a", "b", "c", "d", "e"};
        fullJustify(A, 3);
    }
}
