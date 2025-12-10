
import java.util.HashMap;
import java.util.Map;

public class TargetSum_TopDown {

    /*
    Time -> O(n * 2 * totalSum) -> O(n * totalSum);
    Space -> O(n * 2 * totalSum) -> O(n * totalSum)
  
    TOTALSUM là gì?
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
