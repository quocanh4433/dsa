
public class MonotonicArray {

    /*
     * Time complexity: O(n)
     * 
     * Space complexity: O(1)
     * 
     */
    public static boolean isMonotonic(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return false;
        }

        boolean isDecrease = true;
        boolean isIncrease = true;

        for (int i = 1; i < nums.length; i++) {
            if (!isDecrease && !isIncrease) {
                return false;
            }

            if (nums[i] > nums[i - 1]) {
                isDecrease = false;
            }

            if (nums[i] < nums[i - 1]) {
                isIncrease = false;
            }
        }

        return isDecrease || isIncrease;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        int[] nums2 = {6, 5, 4, 4};
        int[] nums3 = {1, 3, 2};
        System.out.println(isMonotonic(nums)); // exception: true
        System.out.println(isMonotonic(nums2)); // exception: true
        System.out.println(isMonotonic(nums3)); // exception: false
    }
}
