package math;

/**
 * Created by chace on 5/23/14.
 */
public class Fibonacci {

    public static int fibonacci(int n) {
        int[] result = new int[n+1];
        result[0] = 0; result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result[n];
    }
}
