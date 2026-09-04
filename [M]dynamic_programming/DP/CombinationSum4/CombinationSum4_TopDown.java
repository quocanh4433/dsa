
import java.util.Arrays;

public class CombinationSum4_TopDown {
    /*
        time O(n * target)
        sppace O(target)

        n: len(nums)
    */
    private int[] nums;
    private int[] memo;

    public int combinationSum4(int[] nums, int target) {
        // combination sum 1: không quan tâm thứ tự
        // combination sum 4: theo thứ tự
        this.nums = nums;
        this.memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return dfs(target);
    }

    public int dfs(int remain) {
        if (remain == 0) {
            return 1;
        }
        if (remain < 0) {
            return 0;
        }
        if (memo[remain] != -1) {
            return memo[remain];
        }

        int way = 0;
        for (int num : nums) {
            way += dfs(remain - num);
        }

        memo[remain] = way;
        return way;
    }

    public static void main(String[] args) {

    }
}
