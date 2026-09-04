package SearchInRotatedSortedArray;

public class SearchInRotatedSortedArray {

    /*
     * Time complexity: O(logn)
     * 
     * Space complexity: O(1)
     * 
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[l]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[r] >= target && target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = {1};
        System.out.println(search(nums2, 0)); // -1
        System.out.println(search(nums, 0)); // 4
        System.out.println(search(nums, 3)); // -1
    }
}
