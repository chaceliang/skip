package math;

import java.util.Random;

/**
 * Created by chace on 6/18/14.
 */
public class GenerateRandomNumber {
    // Given a random function which return 0/1 equally
    public static int random() {
        Random rand = new Random();
        return rand.nextInt(2);
    }

    // Generate random between a and b, inclusive
    public static int random(int a, int b) {
        int diff = b - a;
        int n = 0;
        while (diff > 0) {
            diff /= 2;
            n++;
        }
        int[] bits = new int[n];
        do {
            for (int i = 0; i < bits.length; i++) {
                bits[i] = random();
            }
        } while (getNumber(bits) > b-a);
        return getNumber(bits) + a;
    }

    public static int getNumber(int[] bits) {
        int result = 0;
        for (int i = 0; i < bits.length; i++) {
            result += Math.pow(2, bits.length - i - 1) * bits[i];
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(random(1, 10));
        }
    }
}
