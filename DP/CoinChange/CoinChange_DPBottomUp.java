import java.util.Arrays;

public class CoinChange_DPBottomUp {
    
    /**
     *  BOTTOM-UP 
     * 
     * Time -> O(n * amount)
     * Space -> O(amount)
     * */
    public int coinChange(int[] coins, int amount) {
        // Mang dp[] với i: số tiền đang có và dp[i]: số cách để dạt được amount
        int MAX = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, MAX);

        dp[amount] = 0;  // từ amount → amount: cần 0 đồng

        for (int cur = amount - 1; cur >= 0; cur--) {
            for (int coin : coins) {
                // ngăn tràn số: cur + coin > Integer.MAX_VALUE
                if (cur > Integer.MAX_VALUE - coin) {
                    continue;
                }
                if (cur + coin <= amount) {
                    dp[cur] = Math.min(dp[cur], 1 + dp[cur + coin]);
                }
            }
        }

        return dp[0] == MAX ? -1 : dp[0];


            
        // int MAX = amount + 1;
        // int[] dp = new int[amount + 1];

        // // fill with infinite large value
        // Arrays.fill(dp, MAX);
        // dp[0] = 0;

        // for (int x = 1; x <= amount; x++) {
        //     for (int coin : coins) {
        //         if (x - coin >= 0) {
        //             dp[x] = Math.min(dp[x], dp[x - coin] + 1);
        //         }
        //     }
        // }

        // return dp[amount] == MAX ? -1 : dp[amount];
    }
    public static void main(String[] args) {
        
    }
}
