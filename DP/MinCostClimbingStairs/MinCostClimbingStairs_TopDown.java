
import java.util.Arrays;

public class MinCostClimbingStairs_TopDown {

    /*
        Time O(n)
        Space O(n)
     */
    int[] memo;

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        memo = new int[n]; // memo[i]: min cost to reach to i-th
        Arrays.fill(memo, -1);

        return Math.min(dfs(cost, n - 1), dfs(cost, n - 2));
    }

    public int dfs(int[] cost, int i) {
        // base case
        if (i < 0) {
            return -1;
        }

        if (i == 0 || i == 1) {
            return cost[i];
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        memo[i] = cost[i] + Math.min(dfs(cost, i - 1), dfs(cost, i - 2));
        return memo[i];
    }

    public static void main(String[] args) {

    }
}
