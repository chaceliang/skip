package edocteel.miscellaneous;

/**
 * Created by chace on 5/7/14.
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int length = prices.length;
        int[] l = new int[length];
        int[] r = new int[length];
        int min = prices[0];
        for (int i = 1; i < length; i++) {
            l[i] = prices[i] - min > l[i - 1] ? prices[i] - min : l[i - 1];
            min = prices[i] < min ? prices[i] : min;
        }
        int max = prices[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            r[i] = max - prices[i] > r[i + 1] ? max - prices[i] : r[i + 1];
            max = prices[i] > max ? prices[i] : max;
        }
        int profit = 0;
        for (int i = 0; i < length; i++) {
            profit = l[i] + r[i] > profit ? l[i] + r[i] : profit;
        }
        return profit;
    }
}
