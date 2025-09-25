
public class MaximunSubarray {

    /**
     * THIS CODE IS NOT OPTIMMIZED - BETTER VERSION IS BELOW
     */
    public int maxSubArray_1(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int maxSum = nums[0], currentSum = 0;
        int l = 0, r = 0;

        while (l <= r && r < nums.length) {
            if (currentSum >= 0) {
                currentSum += nums[r];
                maxSum = Math.max(maxSum, currentSum);
                r++;
            } else {
                currentSum = nums[r];
                maxSum = Math.max(maxSum, currentSum);
                l = r;
                r++;
            }
        }

        return maxSum;
    }

    /**
     * BETTER SOLUTION - BETTER CODE
     *
     * Kadane's Algorithm is a dynamic programming
     *
     * Time complexity: O(n); Space complexity: O(1);
     *
     *
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // exceptio : 6
        int[] nums_2 = {5, 4, -1, 7, 8}; // exception: 23
        int[] nums_3 = {-2, -1}; // exception: -1

        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray(nums_2));
        System.out.println(maxSubArray(nums_3));
    }
}
