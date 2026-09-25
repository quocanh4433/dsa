import java.util.Arrays;

class MaximunGap_Sort {
    /*
        time O(nlogn)
        space O(1)
    
    */
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);

        int res = 0;

        for (int i = 1; i < nums.length; i++) {
            int gap = nums[i] - nums[i - 1];
            res = Math.max(res, gap);
        }

        return res;
    }
}
