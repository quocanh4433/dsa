public class FindPivotIndex {

    public static int pivotIndex(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int n = nums.length;

        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int[] suffix = new int[n];
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            int pre = prefix[i] - nums[i];
            int suf = suffix[i] - nums[i];

            if (pre == suf) {
                return i;
            }
        }

        return -1;
    }

    public static int pivotIndex_2(int[] nums) {
        // Initialize total sum of the given array...
        int totalSum = 0;
        // Initialize 'leftsum' as sum of first i numbers, not including nums[i]...
        int leftsum = 0;
        // Traverse the elements and add them to store the totalSum...
        for (int ele : nums) {
            totalSum += ele;
        }
        // Again traverse all the elements through the for loop and store the sum of i numbers from left to right...
        for (int i = 0; i < nums.length; i++) // sum to the left == leftsum.
        // sum to the right === totalSum - leftsum - nums[i]..
        // check if leftsum == totalSum - leftsum - nums[i]...
        {
            int rightSum = totalSum - leftsum - nums[i];
            if (leftsum == rightSum) {
                return i;       // Return the pivot index...
            }
            leftsum += nums[i];
        }
        return -1;      // If there is no index that satisfies the conditions in the problem statement...
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int[] nums2 = {1, 2, 3};
        int[] nums3 = {2, 1, -1};
        System.out.println(pivotIndex(nums));
        // System.out.println(pivotIndex(nums2));
        // System.out.println(pivotIndex(nums3));
    }
}
