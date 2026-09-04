package GRAPH.NumberOfIslands;

public class NumberOfIslands_DFSRecursion {

    /*
     * DEPTH FIRST SEARCH USING RECURSION
     * 
     */
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }

        m = grid.length;
        n = grid[0].length;
        int island = 0;

        // BFS using QUEUE
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    island++;
                }
            }
        }

        return island;
    }

    public void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            dfs(grid, nr, nc);
        }
    }

    public static void main(String[] args) {

    }
}
