package GRAPH.NumberOfIslands;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands_BFS {

    /*
     * KHÔNG TÁCH HÀM
     * 
     */
    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int island = 0;

        // BFS using QUEUE
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    island++;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    grid[i][j] = '0';

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int r = cur[0];
                        int c = cur[1];

                        for (int[] d : dirs) {
                            int nr = r + d[0];
                            int nc = c + d[1];

                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                                q.offer(new int[]{nr, nc});
                                grid[nr][nc] = '0'; // Phải mark visited ngay ⚠️
                            }
                        }
                    }
                }
            }
        }

        return island;
    }

    /*
     * TÁCH HÀM
     * 
     * 
     */
    private int m;
    private int n;

    public int numIslands_2(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int island = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1') {
                    bfs(grid, r, c);
                    island++;
                }
            }
        }

        return island;
    }

    public void bfs(char[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] d : dirs) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                    q.offer(new int[]{nr, nc});
                    grid[nr][nc] = '0';
                }
            }

        }
    }

    public static void main(String[] args) {

    }
}
