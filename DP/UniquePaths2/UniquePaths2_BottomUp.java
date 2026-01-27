
public class UniquePaths2_BottomUp {
    /*
        time O(n * m)
        space O(n * m)
    */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];  // dp(i, j): số cách đi đến (i,j)

        // nếu điểm xuất phát và kết thúc là chướng ngại vật thì không có cách nào đi đến đích
        if(obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1) {
            return 0;
        }

        dp[0][0] = 1;
       
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(obstacleGrid[r][c] == 1) {
                    dp[r][c] = 0;
                } else {
                    if (r > 0) {
                        dp[r][c] += dp[r - 1][c];
                    }
                    if (c > 0)
                        dp[r][c] += dp[r][c - 1];

                }
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        
    }
}
