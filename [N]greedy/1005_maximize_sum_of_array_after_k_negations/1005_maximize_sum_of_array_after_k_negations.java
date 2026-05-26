
import java.util.Arrays;

class MaximizeSumOfArrayAfterKNegations {

    /**
     * 🎯 Ý tưởng GREEDY
     *
     * ✔️ STEP 1 — Luôn lật số âm nhỏ nhất trước Vì biến số âm thành số dương
     * giúp tăng tổng lớn nhất có thể.
     *
     * ✔️ STEP 2 — Sau khi hết số âm Nếu k vẫn còn ➤ Nếu k chẵn → tổng không đổi
     * Lật 2 lần vào cùng số → trở về ban đầu ➤ Nếu k lẻ → lật số nhỏ nhất trong
     * mảng
     *
     *
     * time: O(nlogn) 
     * space: O(1)
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;

        Arrays.sort(nums);
        for (int i = 0; i < n && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] *= -1;
                k--;
            }
        }

        Arrays.sort(nums);
        if (k % 2 == 1) {
            nums[0] *= -1;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return sum;
    }
}
