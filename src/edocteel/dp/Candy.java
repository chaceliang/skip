package edocteel.dp;

/**
 * Created by chace on 5/14/14.
 */
public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length <= 0) {
            return 0;
        }
        int length = ratings.length;
        int[] candy = new int[length];
        candy[0] = 1;
        for (int i = 1; i < length; i++) {
            candy[i] = ratings[i-1] < ratings[i] ? candy[i-1] + 1 : 1;
        }
        for (int i = length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1] && candy[i] <= candy[i+1]) {
                candy[i] = candy[i+1] + 1;
            }
        }
        int total = 0;
        for (int i = 0; i < length; i++) {
            total += candy[i];
        }
        return total;
    }
}
