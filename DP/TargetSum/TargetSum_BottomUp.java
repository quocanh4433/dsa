
public class TargetSum_BottomUp {

    /*
        time O(n * P)
        space O(n * P)
     */
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        /*
            P + N = totalSum
            P - N = target

            p + (P - target) = totalSum
            P = (totalSum + target) / 2
         */
        // tổng tuyệt đối không thể nhỏ hơn target
        if (totalSum < Math.abs(target)) {
            return 0;
        }
        // P là tổng số nguyên -> P số nguyên -> totalSum + target phải chẵng
        if ((totalSum + target) % 2 != 0) {
            return 0;
        }

        int P = (totalSum + target) / 2;

        // dp(i, j): sô cách tạo tổng j từ i số đầu tiên của mảng nums 
        int[][] dp = new int[n + 1][P + 1];
        // không dùng số nào tạo ra tổng 0 có 1 cách (không chọn)
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            // i đại diện cho số lương, tìm index thì lấy i - 1
            int num = nums[i - 1];

            for (int j = 0; j <= P; j++) {

                // số cách đi tới i với tổng j ít nhất = với sô cách đi tới i - 1
                dp[i][j] = dp[i - 1][j];

                // để chọn num thì j đủ lớn để chứa num
                if (j >= num) {
                    // chon num thì tông còn lại: j -num
                    // tại sao là i - 1 ?
                    dp[i][j] += dp[i - 1][j - num];
                }
            }

        }

        return dp[n][P];

    }

    public static void main(String[] args) {

    }
}
