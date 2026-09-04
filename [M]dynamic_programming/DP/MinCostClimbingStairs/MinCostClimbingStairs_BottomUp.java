public class MinCostClimbingStairs_BottomUp {
    /*
        tim O(n)
        space O(n)
    */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n]; // dp[i]: min cost to reach to i-th
        dp[0] = cost[0];
        dp[1] = Math.min(cost[1] + cost[0], cost[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    /*
        time O(n)
        space O(1)

        optimize space
     */
    public int minCostClimbingStairs_2(int[] cost) {
        int n = cost.length;
        int n1 = cost[1];
        int n2 = cost[0];

        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(n1, n2);
            int temp = n1;
            n1 = curr;
            n2 = temp;
        }
        return Math.min(n1, n2);
    }

    public static void main(String[] args) {
        
    }
}
