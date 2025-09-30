
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

    /**
     * SOLUTION 1: hashmap
     *
     *
     * Time complexity: O(n)
     *
     * space complexity: O(n)
     *
     */
    public static int findLHS(int[] nums) {
        if (nums == null) {
            return 0;
        }

        Map<Integer, Integer> seen = new HashMap<>();
        int longest = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            seen.put(num, seen.getOrDefault(num, 0) + 1);
        }

        for (int key : seen.keySet()) {
            if (seen.containsKey(key + 1)) {
                longest = Math.max(longest, seen.get(key) + seen.get(key + 1));
            }
        }

        return longest;
    }

    /**
     * SOLUTION 2: sort + two pointer
     *
     *
     * Time complexity: O(nlogn)
     *
     * space complexity: O(1)
     *
     */
    public static int findLHS_2(int[] nums) {
        if (nums == null) {
            return 0;
        }

        Arrays.sort(nums);
        /*
        {1, 1, 1, 1, 5, 5, 6};
        s
            e
         */

        int longest = 0;
        int start = 0;

        for (int end = 1; end < nums.length; end++) {
            if (nums[end] - nums[start] == 1) {
                longest = Math.max(longest, end - start + 1);
                continue;
            }

            while (nums[end] - nums[start] > 1) {
                start++;
            }

        }

        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 1, 1, 1, 5, 5, 6};
        System.out.println(findLHS(nums)); // exception: 5
        System.out.println(findLHS(nums2)); // exception: 2
        System.out.println(findLHS(nums3)); // exception: 3

        System.out.println("------------------");

        System.out.println(findLHS_2(nums)); // exception: 5
        System.out.println(findLHS_2(nums2)); // exception: 2
        System.out.println(findLHS_2(nums3)); // exception: 3
    }
}
