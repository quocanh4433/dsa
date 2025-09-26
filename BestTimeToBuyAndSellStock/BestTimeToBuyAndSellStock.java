
public class BestTimeToBuyAndSellStock {

    /**
     * Time complexity: O(n);
     *
     * Space: O(1);
     */
    public static int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {

    }
}
