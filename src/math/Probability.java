package math;

import java.util.Random;

/**
 * Created by chace on 6/7/14.
 */
public class Probability {

    // 以1/(2^n)的概率返回1，其它的时候返回0，题目应该假设有个函数可以生成1或者0，以1/2的概率
    public static int probability(int n) {
        int[] array = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int t = rand.nextInt(1);
            array[i] = t;
        }

        int i;
        for (i = 0; i < n; i++) {
            if (array[i] == 1) {
                break;
            }
        }
        return i == n ? 1 : 0;
    }
}
