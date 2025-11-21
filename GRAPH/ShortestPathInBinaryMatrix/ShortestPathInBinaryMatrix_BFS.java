import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix_BFS {

    /**
     * Time complexity: O(n^2) 
     * 
     * Space complexity: O(n^2)
    */

    /**
     * TAI SAO KHÔNG NÊN GIAI BAI NAY BĂNG BFS ?
     */
    
    private static int[][] dirs = {
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1},           {0, 1},
        {1, -1}, {1, 0}  , {1, 1},
    };
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(n == 0) return -1;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        if(n == 1) return 1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1}); // r , c , distance
        grid[0][0] = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int dis = cur[2];

            for(int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                    if(nr == n - 1 && nc == n - 1) return dis + 1;
                    q.offer(new int[]{nr, nc, dis + 1});
                    grid[nr][nc] = 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        
    }

}
