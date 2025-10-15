
public class FindMinimumInRotatedSortedArray {

    /*
     * Time: O(logn)
     * 
     * Space: O(1)
     * 
     * 
     * 
     */
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int l = 0, r = nums.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l]; // or nums[r]
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums3 = {11, 13, 15, 17};
        System.out.println(findMin(nums)); // 1
        System.out.println(findMin(nums2)); // 0
        System.out.println(findMin(nums3)); // 11
    }
}
