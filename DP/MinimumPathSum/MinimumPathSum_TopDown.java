
public class MinimumPathSum_TopDown {
    /*
        time O(n * m)
            mõi ô tính 1 lần
        space O(n * m)
            memo + stack recursion
    */
    private Integer[][] memo;
    private int n;
    private int m;

    public int minPathSum(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        memo = new Integer[n][m];
        return dfs(grid, 0, 0);
    }

    public int dfs(int[][] grid, int r, int c) {
        if (r >= n || c >= m) {
            return Integer.MAX_VALUE;
        }

        if (memo[r][c] != null) {
            return memo[r][c];
        }

        if (r == n - 1 && c == m - 1) {
            return grid[r][c];
        }

        int right = dfs(grid, r, c + 1);
        int down = dfs(grid, r + 1, c);

        memo[r][c] = grid[r][c] + Math.min(right, down);

        return memo[r][c];
    }

    public static void main(String[] args) {

    }
}
