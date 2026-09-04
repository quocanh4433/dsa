
import java.util.HashMap;
import java.util.Map;

public class TargetSum_TopDown {

    /*
        time -> O(n * 2 * totalSum) -> O(n * totalSum);
        space -> O(n * 2 * totalSum) -> O(n * totalSum)
    */

    private Map<String, Integer> dp;
    private int[] nums;
    private int target;

    public int findTargetSumWays(int[] nums, int target) {
        this.target = target;
        this.nums = nums;
        this.dp = new HashMap<>();
        return dfs(0, 0);
    }

    public int dfs(int i, int curSum) {
        // base case
        if (i == nums.length) {
            return curSum == target ? 1 : 0;
        }

        String key = i + "," + curSum;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int plus = dfs(i + 1, curSum + nums[i]);
        int minus = dfs(i + 1, curSum - nums[i]);

        dp.put(key, plus + minus);
        return plus + minus;
    }

    public static void main(String[] args) {

    }
}
