import java.util.Arrays;

public class CoinChange_DP {
    

    public int coinChange(int[] coins, int amount) {
        int MAX = amount + 1;
        int[] dp = new int[amount + 1];

        // fill with infinite large value
        Arrays.fill(dp, MAX);
        dp[0] = 0;

        for (int x = 1; x <= amount; x++) {
            for (int coin : coins) {
                if (x - coin >= 0) {
                    dp[x] = Math.min(dp[x], dp[x - coin] + 1);
                }
            }
        }

        return dp[amount] == MAX ? -1 : dp[amount];
    }
    public static void main(String[] args) {
        
    }
}
