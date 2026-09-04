public class UniquePaths2_TopDown {
    /*
        time O(n * m)
        space O(n * m)
    */
    private Integer[][] memo;
    private int n;
    private int m;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        n = obstacleGrid.length;
        m = obstacleGrid[0].length;
        memo = new Integer[n][m];
        return dfs(obstacleGrid, 0, 0);
    }

    public int dfs(int[][] grid, int r, int c) {
        if (r >= n || c >= m || grid[r][c] == 1) {
            return 0;
        }

        if (r == n - 1 && c == m - 1) {
            // đi đến đích -> 1 cách đi
            return 1;
        }

        if (memo[r][c] != null) {
            return memo[r][c];
        }

        int moveRight = 0;
        int moveDown = 0;
        moveRight = dfs(grid, r, c + 1);
        moveDown = dfs(grid, r + 1, c);
        memo[r][c] = moveRight + moveDown;
        return memo[r][c];
    }
    public static void main(String[] args) {
        
    }
}
