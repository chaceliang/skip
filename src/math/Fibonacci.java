package math;

/**
 * Created by chace on 5/23/14.
 */
public class Fibonacci {

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static int fibonacci2(int n) {
        int[] result = new int[n+1];
        result[0] = 0; result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(fibonacci(i));
        }
    }
}
