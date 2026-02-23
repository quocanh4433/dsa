
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    /*
        time O(n**2)
        space O(n)
    */

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // dp[i]: subsequnces tới độ dài i + 1
        int[] dp = new int[n];
        // mỗi num là 1 subsequnces
        Arrays.fill(dp, 1); 
       
        // bắt đầu từ cuối mảng nums so sánh với num bên phải
        // nêu num bên phải năm ngoài mảng nums thì không làm gì
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) { // j = 6 -> n
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    /*
                        Tại sao Math.max ? 
                        -> Vì thay đổi liên tục theo j nên cần cập nhật max
                    */
                }
            }
        }

        // duyệt qua từng kết quả trong mảng dp lấy kết quả cao nhất
        int res = -1;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence LIS = new LongestIncreasingSubsequence();
        int[] nums = {1, 2, 4, 3};
        LIS.lengthOfLIS(nums);
    }
}
