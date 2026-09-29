
class MinimumMovesToEqualArrayElementsII_QuickSelect {

    /*
        time O(n) - worst case: O(n**2) khi pivot luôn là phần từ lớn nhất/ nhỏ nhất
        space O(1)

        để tổng nhỏ nhất các phần tử được đưa về median
     */
    public int minMoves2(int[] nums) {
        // "Hãy tìm phần tử nào sẽ nằm ở index nums.length / 2 nếu mảng được sort."
        // ở đây đang tìm median nên len(nums) / 2
        // mở rộng hơn tìm phần từ thứ k tương tự như heap
        int median = quickSelect(nums, nums.length / 2);

        int res = 0;

        for (int num : nums) {
            res += Math.abs(num - median);
        }

        return res;
    }

    public int quickSelect(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // k vị trí mà cần tìm trong sorted array
            // in this problem k is median
            // expand problem is kth element in sorted array

            // pivotIndex cho biết vị trí pivot
            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == k) {
                return nums[pivotIndex];
            } else if (pivotIndex < k) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

        return -1;
    }

    // đưa các phần từ nhỏ hơn hoặc bằng về bên trái và lớn hơn về bên phải
    public int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) { // **lưu ý: j < right
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, right);

        return i;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
