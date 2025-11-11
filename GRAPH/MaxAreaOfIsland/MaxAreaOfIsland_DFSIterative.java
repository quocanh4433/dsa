package GRAPH.MaxAreaOfIsland;

import java.util.Stack;

public class MaxAreaOfIsland_DFSIterative {

    /*
     * Time complexity: O(m * n)
     * 
     * Space complexity: O(m * n) Worst case : toàn bộ ma trận là 1
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
                    int area = 1;

                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{r, c});
                    grid[r][c] = 0;

                    while (!stack.isEmpty()) {
                        int[] cur = stack.pop();

                        for (int[] d : dirs) {
                            int nr = cur[0] + d[0];
                            int nc = cur[1] + d[1];

                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                                area++;
                                grid[nr][nc] = 0;
                                stack.push(new int[]{nr, nc}); // Phải mark visited ngay ⚠️
                            }
                        }

                    }

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

    }
}
