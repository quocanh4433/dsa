
import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations {

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
     * Time: O(nlogn)
     * Space: O(1)
     */

    public int largestSumAfterKNegations(int[] nums, int k) {
        // STEP 1: Flip all negative values
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] *= -1;
                k--;
            }
        }

        // STEP 2: k still odd
        Arrays.sort(nums);
        if (k % 2 == 1) {
            nums[0] *= -1;
        }

        // STEP 3: 
        int res = 0;
        for (int num : nums) {
            res += num;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
