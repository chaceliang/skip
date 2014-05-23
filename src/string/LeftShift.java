package string;

/**
 * Created by chace on 5/22/14.
 */
public class LeftShift {

    // abcdef => cdefab

    public static String leftShift(String input, int n) {
        if (input == null || input.length() <= 0) {
            return input;
        }

        n = n % input.length();
        int len = input.length();
        if (n < 0) {
            n = len + n;
        }
        char[] a = input.toCharArray();
        int s = 0, e = a.length - 1;
        while (s <= e) {
            char tmp = a[s];
            a[s] = a[e];
            a[e] = tmp;
            s++; e--;
        }

        s = 0;
        e = len - n - 1;
        while (s <= e) {
            char tmp = a[s];
            a[s] = a[e];
            a[e] = tmp;
            s++; e--;
        }
        s = len - n;
        e = len - 1;
        while (s <= e) {
            char tmp = a[s];
            a[s] = a[e];
            a[e] = tmp;
            s++; e--;
        }
        return new String(a);
    }

    public static void main(String[] args) {
        System.out.println(leftShift("abcdef", 2));
        System.out.println(leftShift("abcdef", -2));
        System.out.println(leftShift("abcdef", 0));
    }
}
