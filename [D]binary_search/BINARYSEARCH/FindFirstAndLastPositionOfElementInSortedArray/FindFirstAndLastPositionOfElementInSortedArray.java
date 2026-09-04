
public class FindFirstAndLastPositionOfElementInSortedArray {
    /*
        Biến thể của Binarysearch không dừng lại khi tìm được target mà ép về phía cần tìm
        Time -> O(logn) -> 2 lần binary search
        Space -> O(1)
    
     */

    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        return new int[]{left, right};
    }

    public int binarySearch(int[] nums, int target, boolean isSearchLeft) {
        /*
            Ý nghĩa isSearchLeft ?
            isSearchLeft = true -> tìm tiếp về bên trái
            isSearchLeft = false -> tìm tiếp về bên phải

         */

        int l = 0;
        int r = nums.length - 1;
        int idx = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r--;
            } else if (nums[mid] < target) {
                l++;
            } else {
                idx = mid;
                if (isSearchLeft) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return idx;
    }
    public static void main(String[] args) {
        
    }
}
