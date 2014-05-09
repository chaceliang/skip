package edocteel.math;

/**
 * Created by chace on 5/8/14.
 */
public class PrimeNumber {
    public static boolean isPrime(int n) {
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 200; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }
}
