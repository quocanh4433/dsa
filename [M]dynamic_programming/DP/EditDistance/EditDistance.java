public class EditDistance {
    /*
        Time: O(n * m)
        Space: O(n * m)
    */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];

        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i; //  dp[i][0]: số cách để đưa word1 về rỗng
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j; //  dp[0][j]: số cách để đưa word2 về rỗng
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    //👉 Không cần thao tác gì thêm.
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        
    }
}
