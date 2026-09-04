package GRAPH.MaxAreaOfIsland;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland_BFS {

    /*
     * Time complexity: O(m * n)
     * 
     * Space complexity: O(m * n) Worst case : toàn bộ ma trận là 1
     * 
     * 
     */
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int maxArea = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int area = 1;

                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{r, c});
                    grid[r][c] = 0; // Phải mark visited ngay, HAY QUÊN 🔥

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        for (int[] d : dirs) {
                            int nr = cur[0] + d[0];
                            int nc = cur[1] + d[1];

                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                                area++;
                                grid[nr][nc] = 0;
                                q.offer(new int[]{nr, nc}); // Phải mark visited ngay ⚠️
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}
