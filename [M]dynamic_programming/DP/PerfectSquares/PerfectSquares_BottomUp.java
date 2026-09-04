import java.util.Arrays;

public class PerfectSquares_BottomUp {
    /*
        time O(n * sqrt(n))
        space O(n)
    */
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // dp(i): số lượng số chính phương tạo ra i
        Arrays.fill(dp, n);
        dp[0] = 0;

        for(int target = 1; target <= n; target++) {
            for(int s = 1; s * s <= target; s++) {
                dp[target] = Math.min(dp[target], 1 + dp[target - s * s]);
            }
        }
        
        return dp[n];
    }

   
    public static void main(String[] args) {
        
    }
}
