
class MinimumOperationsToMakeTheArrayIncreasing {
    /*
        time O(n)
        space O(1)
    */
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int ans = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                continue;
            }
            int diff = nums[i - 1] - nums[i] + 1;
            nums[i] = nums[i] + diff;
            ans += diff;
        }
        return ans;
    }
}
