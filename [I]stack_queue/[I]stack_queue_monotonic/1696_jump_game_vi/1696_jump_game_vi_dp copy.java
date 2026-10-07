
class JumpGameVI_DP {

    /*
        time O(n * k) worst case k = n = 10**5 -> TLE
        space O(n)
     */

    public int maxResult(int[] nums, int k) {
        int n = nums.length;

        int[] dp = new int[n];

        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MIN_VALUE;

            for (int j = Math.max(0, i - k); j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            }
        }

        return dp[n - 1];
    }
}
