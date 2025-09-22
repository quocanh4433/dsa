import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement2 {
    /**
     * Given an integer array of size n, find all elements that appear more than ⌊
     * n/3 ⌋ times.
     * 
     * Example 1:
     * Input: nums = [3,2,3]
     * Output: [3]
     * 
     * Example 2:
     * Input: nums = [1]
     * Output: [1]
     * 
     * Example 3:
     * Input: nums = [1,2]
     * Output: [1,2]
     * 
     * 
     * Constraints:
     * 1 <= nums.length <= 5 * 104
     * -109 <= nums[i] <= 109
     * 
     * 
     * Follow up: Could you solve the problem in linear time and in O(1) space?
     */

    static List<Integer> majorityElement(int[] nums) {
        if (nums == null)
            return new ArrayList<>();

        Map<Integer, Integer> count = new HashMap<>(3);

        for (int num : nums) {
            count.putIfAbsent(num, count.getOrDefault(num, 0) + 1);

            if (count.size() <= 2)
                continue;

            Map<Integer, Integer> newCount = new HashMap<>(3);
            count.forEach((key, value) -> {
                if (value > 1) {
                    newCount.put(key, value - 1);
                }
            });

            count = newCount;
        }

        List<Integer> res = new ArrayList<>();

        for (int candidate : count.keySet()) {
            int freq = 0;

            for (int num : nums) {
                if (num == candidate)
                    freq++;
            }

            if (freq > (nums.length / 3)) {
                res.add(candidate);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // int[] nums = { 3, 2, 3 };
        // int[] nums_2 = { 1, 2 };
        // int[] nums_3 = { 1 };

        /* FAIL these testcase */
        // int[] nums_4 = { 1, 2, 1, 2, 1, 2, 3, 4 };
        int[] nums_5 = { 2, 2, 1, 3 };

        // System.out.println(majorityElement(nums));
        // System.out.println(majorityElement(nums_2));
        // System.out.println(majorityElement(nums_3));
        // System.out.println(majorityElement(nums_4));
        System.out.println(majorityElement(nums_5));
    }
}
