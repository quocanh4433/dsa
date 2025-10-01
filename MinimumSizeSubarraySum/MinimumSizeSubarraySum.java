
public class MinimumSizeSubarraySum {

    /**
     * Time complexity: O(n)
     *
     * Space: O(1)
     */
    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || target < 0) {
            return 0;
        }

        int l = 0;
        int total = 0;
        int res = Integer.MAX_VALUE;

        for (int r = 0; r < nums.length; r++) {
            total += nums[r];

            while (total >= target) {
                res = Math.min(res, r - l + 1);
                total -= nums[l];
                l++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int[] nums2 = {4, 4, 1};
        System.out.println(minSubArrayLen(7, nums)); // exception: 2
        System.out.println(minSubArrayLen(4, nums2)); // exception: 1
    }
}

/*
{2, 3, 1, 2, 4, 3}
          l
             r

target = 7
res = MAX_VALUE
total =  7

total >= target 
    res = min(r - l + 1, res)
    l++
    total -= nums[l]











 */
