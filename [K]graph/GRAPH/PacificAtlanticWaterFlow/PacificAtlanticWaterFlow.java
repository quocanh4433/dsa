
import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    /*
     * Time complexity: O(m * n)
     * Space complexity: O(m * n)
     * 
     */

    private int ROWS;
    private int COLS;
    private static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;

        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        // pacific left + above
        for (int i = 0; i < ROWS; i++) {
            dfs(heights, pacific, i, 0);
        }
        for (int j = 0; j < COLS; j++) {
            dfs(heights, pacific, 0, j);
        }

        // atlantic right + bottom
        for (int i = 0; i < ROWS; i++) {
            dfs(heights, atlantic, i, COLS - 1);
        }
        for (int j = 0; j < COLS; j++) {
            dfs(heights, atlantic, ROWS - 1, j);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(r);
                    cur.add(c);
                    res.add(cur);
                }
            }
        }

        return res;
    }

    public void dfs(int[][] heights, boolean[][] visited, int r, int c) {
        visited[r][c] = true;

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nc < 0 || nr >= ROWS || nc >= COLS || visited[nr][nc]) {
                continue;
            }
            if (heights[nr][nc] < heights[r][c]) {
                continue;
            }

            dfs(heights, visited, nr, nc);
        }
    }

    public static void main(String[] args) {

    }
}
