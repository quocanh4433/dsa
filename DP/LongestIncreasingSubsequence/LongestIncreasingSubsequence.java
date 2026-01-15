
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    /*
        Time: O(2^n)
        Space: O(n)

    
    */

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Mỗi phân từ là 1 subsequnces
        // 1 1 1 1
        // 1 2 4 3
        for (int i = n - 1; i >= 0; i--) { // i = 5 -> 0
            for (int j = i + 1; j < nums.length; j++) { // j = 6 -> n
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    /*
                        Tại sao Math.max ? 
                        -> Vì thay đổi liên tục theo j nên cần cập nhật max
                    */
                }
            }
        }

        int res = -1;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence LIS = new LongestIncreasingSubsequence();
        int[] nums = {1, 2, 4, 3};
        LIS.lengthOfLIS(nums);
    }
}
