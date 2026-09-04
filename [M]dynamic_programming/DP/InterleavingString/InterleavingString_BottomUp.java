
public class InterleavingString_BottomUp {

    /*
        time O(n * m)
        space O(n * m)
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if(n + m != s3.length()) return false;

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        // cột đầu
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0]
                    && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        // hàng đầu
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1]
                    && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // fill bảng
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c = s3.charAt(i + j - 1);
                dp[i][j]
                        = (dp[i - 1][j] && s1.charAt(i - 1) == c)
                        || (dp[i][j - 1] && s2.charAt(j - 1) == c);
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

    }
}
