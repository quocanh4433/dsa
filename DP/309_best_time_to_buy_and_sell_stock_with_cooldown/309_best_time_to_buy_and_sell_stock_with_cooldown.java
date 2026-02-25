
class Solution {
    /*
        time: O(n)
        space: O(1)
    */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        /*
            ở mỗi stock có 3 state:

            - hold (giữ): profit tốt nhất cuối ngày i khi giữ stock
            - sold (bán): profit tốt nhất cuối ngày i khi bán stock ở ngày trước đó
            - rest (cooldown): 
         */

        // ngày đầu tiên 
        // profit khi giữa stock thì lợi nhuận bị âm
        int hold = -prices[0];
        // bán stock ở ngày trước đó mà ngày trước đó không tồn tại nên giá trị là MIN
        int sold = Integer.MIN_VALUE;
        // không làm gì nên profit là 0
        int rest = 0;

        for (int i = 0; i < prices.length; i++) {
            // trạng thái ngày hôm qua
            int prevHold = hold;
            int prevSold = sold;
            int prevRest = rest;

            // hôm qua đã giữa hôm nay giữ tiếp (prevHold)
            // hôm qua nghỉ hôm nay mua (prevRest - prices[i])
            hold = Math.max(prevHold, prevRest - prices[i]);

            // muốn bán thì hôm qua bắt buộc giữa (prevHold)
            // không max vì bán là hành động trong hôm nay
            sold = prevHold + prices[i];

            // hôm qua đã nghỉ hôm nay tiếp tục nghỉ (prevRest)
            // hôm qua đã bán hôm nay nghỉ (prevSold)
            rest = Math.max(prevRest, prevSold);
        }

        return Math.max(sold, rest);
    }
}
