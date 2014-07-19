package edocteel.miscellaneous;

/**
 * Created by chace on 5/7/14.
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int bot = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < bot) {
                bot = prices[i];
            }
            if (prices[i] - bot > maxProfit) {
                maxProfit = prices[i] - bot;
            }
        }
        return maxProfit;
    }
}
