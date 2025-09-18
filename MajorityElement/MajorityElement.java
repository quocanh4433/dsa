public class MajorityElement {

    /*
     * Majority Element
     * 
     * Given an array nums of size n, return the majority element.
     * 
     * The majority element is the element that appears more than ⌊n / 2⌋ times in
     * the array. You may assume that the majority element always exists in the
     * array.
     * 
     * Example 1:
     * Input: nums = [5,5,1,1,1,5,5]
     * Output: 5
     * 
     * Example 2:
     * Input: nums = [2,2,2]
     * Output: 2
     * 
     * Constraints:
     * 1 <= nums.length <= 50,000
     * -1,000,000,000 <= nums[i] <= 1,000,000,000
     * 
     * 
     * time complexity: O(n)
     * soace complexity: O(1)
     * 
     */

    static int majorityElement(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int res = nums[0];
        int v = 1;

        for (int i = 1; i < nums.length; i++) {
            if (v == 0)
                res = nums[i];

            if (res == nums[i]) {
                v++;
            } else {
                v--;
            }
            // v += res == nums[1] ? 1 : -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3 };
        int[] nums_2 = { 2, 2, 1, 4, 4, 4, 4, 3, 3 };
        int[] nums_3 = { 5, 5, 1, 1, 1, 5, 5 };

        System.out.println(majorityElement(nums));
        System.out.println(majorityElement(nums_2));
        System.out.println(majorityElement(nums_3));
    }
}
