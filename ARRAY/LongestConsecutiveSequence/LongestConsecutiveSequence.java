import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    /*
     * { 100, 4, 200, 1, 3, 2}
     * { 1, 2, 3, 4, 100, 200}
     * 
     * 
     * Time complexity O(nlogn)
     * Space complexity: O(nlogn) - tuy không tạo ra biến mới nhưng Aray.sort cần
     * stack recurtion
     * 
     * 
     */

    /**
     * 
     * THIS CODE IS NOT OPTIMIZED - THE BETTER VERSION IS BELOW
     * 
     */
    static int longestConsecutive_1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;

        int n = nums.length;
        Arrays.sort(nums);
        int res = 1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                count++;
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] + 1) {
                count++;
                continue;
            }

            if (i > 0 && nums[i] != nums[i - 1] && nums[i] != nums[i - 1] + 1) {
                res = Math.max(res, count);
                count = 1;
            }
        }

        return Math.max(res, count);
    }

    /**
     * 
     * ENHACHED VERSION / UPGRADED VERSION
     * 
     * Time: O(nlogn)
     * Space: O(nlogn)
     * **********************************************************
     */
    public static int longestConsecutive_2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;

        Arrays.sort(nums);
        int res = 1;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                continue; // skip duplicate

            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }

            res = Math.max(res, count);
        }

        return res;

    }

    /**
     * 
     * THIS IS BETTER SOLUTION
     * 
     * Time: O(n)
     * Space: O(n)
     */

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;

        Set<Integer> setNum = new HashSet<>();
        for (int num : nums) {
            setNum.add(num);
        }

        int res = 0;
        for (int num : setNum) {
            if (!setNum.contains(num - 1)) {
                int count = 1;

                while (setNum.contains(num + count)) {
                    count++;
                }

                res = Math.max(res, count);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 3, 2, 5, 4, 6, 1, 1 };
        System.out.println(longestConsecutive(nums));

        int[] nums_2 = { 2, 20, 4, 10, 3, 4, 5 };
        System.out.println(longestConsecutive(nums_2));

        /** FAIL AT THESE TESTCASE */
        int[] nums_3 = {}; // exception 0
        int[] nums_4 = { 0 }; // exception 1
        int[] nums_5 = { 9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6 }; // exception 7
        int[] nums_6 = { 100, 4, 200, 1, 3, 2 }; // exception 4
        System.out.println(longestConsecutive(nums_3));
        System.out.println(longestConsecutive(nums_4));
        System.out.println(longestConsecutive(nums_5));
        System.out.println(longestConsecutive(nums_6));

    }
}
