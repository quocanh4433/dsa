package GRAPH.MaxAreaOfIsland;

public class MaxAreaOfIsland_DFSRecusion {

    /*
     * Time complexity O(m * n)
     * 
     * Space complexity: O(m * n)
     * 
     * Do constrains: 1 <= m, n <= 50
     * 
     * Nên vẫn có thể sử dụng đệ quy 
     * 
     * 
     */
    private int m;
    private int n;
    private final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int[] area = {0};
                    dfs(grid, r, c, area);
                    maxArea = Math.max(maxArea, area[0]);
                }
            }
        }

        return maxArea;
    }

    public void dfs(int[][] grid, int r, int c, int[] area) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) {
            return;
        }
        area[0]++;
        grid[r][c] = 0;
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            dfs(grid, nr, nc, area);
        }
    }
}
