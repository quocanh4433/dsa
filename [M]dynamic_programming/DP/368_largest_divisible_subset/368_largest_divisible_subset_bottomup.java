
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    /*
        time: O(n**2)
        space: O(n)
     */
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] prev = new int[n];
        int[] dp = new int[n]; // dp[i]: độ dài kết thúc tại i
        Arrays.fill(prev, -1);
        Arrays.fill(dp, 1);

        int maxLen = 0;
        int start = 0; // là điểm bắt đầu của chuỗi chia hết dài nhất.

        // kiểm tra từ 0 đến trước i có số nào nối với i
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                // kiêm tra nums[j] có nối được với nums[i]
                // && có tạo ra độ dài mới lơn hơn
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                start = i; // cập nhật điểm bắt đầu mới
            }
        }

        List<Integer> res = new ArrayList<>();
        while (start != -1) {
            res.add(nums[start]); // thêm nums tại điểm bắt đầu
            start = prev[start]; // cập nhật index tiếp theo
        }

        return res;
    }
}
