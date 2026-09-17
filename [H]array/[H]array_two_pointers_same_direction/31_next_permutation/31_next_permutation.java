
class NextPermutation {

    /*
        time O(n)
        space O(1)

        1. Từ phải → tìm i sao cho nums[i] < nums[i+1]

        2. Từ phải → tìm số nhỏ nhất > nums[i]

        3. Swap

        4. Reverse phần sau i
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        int n = nums.length;

        // 1. find i
        // i chính là vị trí cuối cùng để permutation lớn hơn
        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 2. find j
        // nếu i < 0 tức nums đang làm permutation lớn nhất chỉ cần reverse toàn bộ mảng
        // để quay lại permutation nhỏ nhất
        if (i >= 0) {
            int j = n - 1;

            while (nums[j] <= nums[i]) {
                j--;
            }

            swap(nums, i, j);

        }

        reverse(nums, i + 1, n - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
}
