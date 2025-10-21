
public class BinarySearch {

    /**
     * Time complexity: O(logn)
     *
     * Space complexity: O(1)
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums, 9)); // 4
        int[] nums2 = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums2, 2)); // -1 
        int[] nums3 = {1, 0, 2, 4, 6, 8};
        System.out.println(search(nums3, 3)); //
    }
}
