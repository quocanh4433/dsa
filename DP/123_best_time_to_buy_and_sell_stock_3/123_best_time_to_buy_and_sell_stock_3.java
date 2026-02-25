
class Solution {

    /*
        time: O(n)
        space: O(1)
     */
    public int maxProfit(int[] prices) {
        // 🔑 BUY / SELL không lưu giá — mà lưu LỢI NHUẬN (profit)
        // buy1: lời nhuận tốt nhất lại sau khi giữ stock
        // sell1: lợi nhuận tốt nhất sau khi bán stock

        // 🔑 Phải sell mới được buy tiếp
        int sell1 = 0;
        int sell2 = 0;

        // tại sao buy1 và buy2 có gía trị mặc định làmin min mà không phải = 0?
        // lúc đầu chưa có lợi nhuận nhưng vẫn phải bỏ tiền ra mua
        // nên lời nhuận < 0;
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;

        for (int price : prices) {
            // tại sao không phải buy1 = max(buy1, buy1 - price)
            // chưa có profit ban đâu (0) mà lại trả tiền mua stock (- price) -> 0 - price
            buy1 = Math.max(buy1, 0 - price);

            // có 2 lưa chọn giữ hoặc bán stock mua ở lần 1
            // nếu bán stock ở lần 1 thì lời nhuận được tính
            // tiên đang giữ stock (buy1) + giá stock (price) -> buy1 + price
            sell1 = Math.max(sell1, buy1 + price);

            // sau khi đã bán sell1 có thể tiếp tục mua 2
            buy2 = Math.max(buy2, sell1 - price);

            sell2 = Math.max(sell2, buy2 + price);
        }

        return sell2;
    }
}
