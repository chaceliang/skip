package math;

/**
 * Created by chace on 5/24/14.
 */
public class Rand7 {

    public static int rand7() {
        int i;
        do {
            i = 5 * (rand5() - 1) + rand5();
        } while (i > 21);
        return i % 7 + 1;
    }

    public static int rand5() {
        return 5;
    }

    public static int rand72() {
        int[][] vals = {
            { 1, 2, 3, 4, 5 },
            { 6, 7, 1, 2, 3 },
            { 4, 5, 6, 7, 1 },
            { 2, 3, 4, 5, 6 },
            { 7, 0, 0, 0, 0 }
        };
        int result = 0;
        while (result == 0) {
            int i = rand5();
            int j = rand5();
            result = vals[i][j];
        }
        return result;
    }
}
