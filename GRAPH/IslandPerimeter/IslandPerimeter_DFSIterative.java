package GRAPH.IslandPerimeter;

import java.util.LinkedList;
import java.util.Queue;

public class IslandPerimeter_DFSIterative {

    /*
     * 🚨 NẾU KHÔNG ĐÁNH DÂU VISITED, MỘT Ô DUYỆT NHIỀU LẦN
     * Time complexity: O((m * n)^2)
     * 
     * Space complexity: O((m * n)^2) Worst case : toàn bộ ma trận là 1
     * 
     * 
     * 🚨 NẾU ĐÁNH DÂU VISITED
     * Time complexity: O(m * n)
     * 
     * Space complexity: O(m * n) Worst case : toàn bộ ma trận là 1
     * 
     * 
     */
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int perimeter = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {

                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{r, c});


                    /*
                    * 🚨 VẤN ĐỀ LOGIC
                    * 
                    * Nếu không đánh dâu visited nên cùng 1 ô duyệt qua nhiều lần
                     */
                    grid[r][c] = -1;

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int[] d : dirs) {
                            int nr = cur[0] + d[0];
                            int nc = cur[1] + d[1];

                            if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] == 0) {
                                perimeter++;
                            }
                        }
                    }
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {

    }
}
