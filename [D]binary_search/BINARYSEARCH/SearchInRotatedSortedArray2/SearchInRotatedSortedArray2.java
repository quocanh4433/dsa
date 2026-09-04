package SearchInRotatedSortedArray2;

public class SearchInRotatedSortedArray2 {

    /*
     * Time complexity: O(logn)
     * 
     * Space complexity: O(1)
     * 
     */
    public static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] == nums[l] && nums[mid] == nums[r]) {
                l++;
                r--;
            } else if (nums[mid] >= nums[l]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target >= nums[r] && nums[mid] > target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        System.out.println(search(nums, 0)); // true
        System.out.println(search(nums, 3)); // false
    }
}
