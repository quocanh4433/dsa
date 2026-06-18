import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MinimumSubsequenceInNonIncreasingOrder {
    /*
        time O(nlogn)
        space O(n)

        ý tưởng greedy:
        sort và lấy phần lớn nhất trước
    */
    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int currSum = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            ans.add(nums[i]);
            currSum += nums[i];
            int diffSum = sum - currSum; // tổng còn lại
            if (currSum > diffSum) {
                return ans;
            }
        }

        return null;
    }
}
