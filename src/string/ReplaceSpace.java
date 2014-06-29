package string;

/**
 * Created by chace on 6/9/14.
 */
public class ReplaceSpace {

    public static String replaceSpace(String input) {
        if (input == null) {
            throw new NullPointerException();
        }
        int i = 0, j = 0, len = input.length();
        char[] tmp = input.toCharArray();

        while (j < len) {
            while (j < len && tmp[j] == ' ') {
                j++;
            }
            if (j == len) {
                break;
            }
            while (j < len && tmp[j] != ' ') {
                swap(tmp, i, j);
                i++; j++;
            }
            if (j == len) {
                break;
            }
            // Add space between words
            swap(tmp, i, j);
            i++;
            j++;
        }
        return new String(tmp);
    }

    public static void swap(char[] A, int i, int j) {
        char t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("  Hello   World        yoyo ") + "|");
    }
}
