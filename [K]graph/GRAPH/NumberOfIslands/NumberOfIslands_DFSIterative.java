package GRAPH.NumberOfIslands;

import java.util.Stack;

public class NumberOfIslands_DFSRecursion {

    /*
     * DEPTH FIRST SEARCH ITERATIVE
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
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1') {
                    island++;
                    grid[r][c] = '0';

                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{r, c});

                    while (!stack.isEmpty()) {
                        int[] cur = stack.pop();

                        for (int[] d : dirs) {
                            int nr = cur[0] + d[0];
                            int nc = cur[1] + d[1];

                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                                stack.push(new int[]{nr, nc});
                                grid[nr][nc] = '0';
                            }
                        }
                    }

                }
            }
        }

        return island;
    }

    public static void main(String[] args) {

    }
}
