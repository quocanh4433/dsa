


public class UniquePaths_BottomUp {
    /*
        ✅ phù hợp phỏng vấn
        time: O(n * m)
        space: O(m)
     */
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (c > 0) {
                    dp[c] += dp[c - 1];
                }
            }
        }

        return dp[n - 1];
    }


    /*
        time: O(n * m)
        space: O(n * m)
    */

    public static void main(String[] args) {

    }
}
