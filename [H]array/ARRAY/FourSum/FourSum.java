import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    /**
     *
     * SOLUTION 1: sort + 4 pointer
     *
     * Time complexity: O(n^3)
     *
     * Space complexity:
     *
     * - Nếu tính List<List<Integer>> res -> O(k) , k = number of quarublet.
     * Worst-case O(n³), nhiều cập 4 số = target
     *
     * - Nếu không tính List<List<Integer>> res -> O(1);
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null) {
            return new ArrayList<>();
        }

        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int l = j + 1;
                int r = n - 1;

                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];

                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r + 1]) {
                            r--;
                        }
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        return res;
    }

    /**
     * SOLUTION 2: hashmap
     *
     * Time complexity: O(n^2)
     *
     * Space complexity: O(n^2)
     *
     * ✅ Ưu điểm:Nhanh hơn, hiệu quả với n vừa phải
     *
     * ❌ Nhược điểm: Tốn bộ nhớ lớn, dễ bị duplicates
     *
     * LÀM SAU
     */
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums, 0));

        /**
         * FAIL AT TESTCASE tranfer varaiable int sum -> long sum
         */
        int[] nums_2 = {1000000000, 1000000000, 1000000000, 100000000};
        System.out.println(fourSum(nums_2, -294967296));
    }
}
