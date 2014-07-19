package string;

import java.util.NoSuchElementException;

/**
 * Created by chace on 6/6/14.
 */
public class StringShuffle {
    // abc123 <=> a1b2c3

    // abc123 => a1b2c3
    public static String shuffle1(String input) {
        if (input == null || input.length() <= 0) {
            return null;
        }
        int len = input.length();
        if (len % 2 != 0) {
            throw new NoSuchElementException();
        }
        int i = len / 2 - 1, j = len / 2;
        char[] c = input.toCharArray();
        while (i > 0 && j < len -1 ) {
            int start = i;
            while (start < j) {
                swap(c, start, start + 1);
                start += 2;
            }
            i--; j++;
        }
        return new String(c);
    }

    // abc123 <= a1b2c3
    public static String shuffle2(String input) {
        if (input == null || input.length() <= 0) {
            return null;
        }
        int len = input.length();
        if (len % 2 != 0) {
            throw new NoSuchElementException();
        }
        int i = 1, j = len -2;
        char[] c = input.toCharArray();
        while (i < j) {
            int start = i;
            while (start < j) {
                swap(c, start, start + 1);
                start += 2;
            }
            i++; j--;
        }
        return new String(c);
    }

    public static void swap(char[] A, int i, int j) {
        char tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(shuffle1("a1"));
        System.out.println(shuffle1("ab12"));
        System.out.println(shuffle1("abc123"));
        System.out.println(shuffle1("abcd1234"));

        System.out.println(shuffle2("a1"));
        System.out.println(shuffle2("a1b2"));
        System.out.println(shuffle2("a1b2c3"));
        System.out.println(shuffle2("a1b2c3d4"));
    }
}
