
public class OnesAndZeroes_BottomUp_Optimize {

    /*
        time O(m * n * N)
        space O(m * n)
     */

    public int findMaxForm(String[] S, int M, int N) {
        int[][] dp = new int[M + 1][N + 1];
        for (String str : S) {
            int zeros = 0, ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            for (int i = M; i >= zeros; i--) {
                for (int j = N; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[M][N];
    }

    public static void main(String[] args) {

    }
}
