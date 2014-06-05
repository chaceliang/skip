package math;

/**
 * Created by chace on 6/4/14.
 */
public class ZeroNumbers {
    public static int getZeroNumber(int num) {
        int count = 0;
        if (num < 5) {
            return count;
        }
        for (int i = 5; i <= num; i += 5) {
            int number = i;
            while (number % 5 == 0) {
                number /= 5;
                count++;
            }
        }
        return count;
    }
}
