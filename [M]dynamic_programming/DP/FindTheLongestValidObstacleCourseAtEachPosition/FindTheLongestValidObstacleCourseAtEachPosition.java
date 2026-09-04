public class FindTheLongestValidObstacleCourseAtEachPosition {
    /*
        time limit exceeded ❌❌❌

        time O(n**2)
        sapce O(n)

        1 <= n <= 105
    */

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            // kiểm tra có nối đến các obstsacle phía trước
            for (int j = 0; j < i; j++) {
                if (obstacles[j] <= obstacles[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    // +1: công cho phân từ thư i
                }
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        
    }
}
