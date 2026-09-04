
public class UniquePaths2_BottomUp_OptimizeSpace {
    /*
        time O(n * m)
        space O(m)

        ✅ phù hợp phỏng vấn
        👉 xem từ phút thứ 5: https://www.youtube.com/watch?v=a98MtHkiil4
        

        mỗi ô (i, j) chỉ phụ thuộc ô ở trên và bên trái

        dp[j]: số cách tới cột j ở hàng hiện tại
        dp[j] = dp[j] + dp[j-1]
    */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] dp = new int[m];

        // nếu điểm xuất phát và kết thúc là chướng ngại vật thì không có cách nào đi đến đích
        if (obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1) {
            return 0;
        }

        dp[0] = 1;
       
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(obstacleGrid[r][c] == 1) {
                    dp[c] = 0;
                } else if(c > 0) {
                    dp[c] += dp[c - 1];
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        
    }
}
