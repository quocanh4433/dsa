public class BestTimeToBuyAndSellStock2 {

    // Bài 122 chính là nền tảng để hiểu các bài phức tạp hơn — các bài sau chỉ thêm điều kiện hoặc mở rộng số state mà thôi


    /**
     * 💡 IDEA: 
     * “Cứ khi nào giá hôm sau cao hơn hôm nay, ta bán” có tối ưu không?
     * 
     * 👉 Nếu như vậy thì làm sao đảm bảo profit cuối cùng là maxprofit?
     * 
     * 
     * 👉 Greedy chính là Dynamic programming đúng không?
     * 
     * 
     */

    // Ultimate transaction (Mua bán không giới hạn)
    // GIẢI THEO GREEDY - Cứ lời là bán
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }


    // GIẢI THEO DP
    public int maxProfit_DP(int[] prices) {
        int n = prices.length;
        int[] hold = new int[n];
        int[] notHold = new int[n];

        hold[0] = -prices[0];
        notHold[0] = 0;

        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], notHold[i - 1] - prices[i]);
            notHold[i] = Math.max(notHold[i - 1], hold[i - 1] + prices[i]);
        }

        return notHold[n - 1];
    }

    public static void main(String[] args) {

    }
}
