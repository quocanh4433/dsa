
import java.util.*;

class Solution {

    /*
        time: O(n^2 * logn)
        space: O(n^2)

        bài toán
            ▪︎ bạn đang bới
            ▪︎ nước dâng theo thời gian t 
            ▪︎ bạn di chuyển theo chiều cao nước dân

        bẫy
            ⛔ quan tâm đến thơi gian nước dân t
            ⛔ quan tâm đền hướng đi tiếp theo ở thời gian t

        thay đổi suy nghĩ thay vi
            “Tôi bơi từ ô này sang ô kia mất bao lâu?”
        thì 
            “Tôi phải chờ nước dâng đến mức nào thì các ô nối với nhau thành một con đường?”

    
     */
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // dist[x][y]: mực nước thấp nhất cần có để đi từ (0,0) đến (x,y)
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // mực nước nhỏ nhất đi tới 0 là grid[0][0]
        dist[0][0] = grid[0][0];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{grid[0][0], 0, 0}); // {elevation, 0, 0}

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int elevation = cur[0];
            int x = cur[1];
            int y = cur[2];

            if (elevation > dist[x][y]) {
                continue;
            }
            if (x == m - 1 && y == n - 1) {
                return elevation;
            }

            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx == m || ny == n) {
                    continue;
                }

                /*
                    đang ở ô (x, y) muốn bước sang ô (nx, ny)
                    thì mực nước phaỉ đủ cao cho ô mới (nx, ny)

                    newElevation = max(
                        mực nước cần cho đường đã đi,
                        độ cao của ô sắp bước vào
                    )
                 */
                int newElevation = Math.max(elevation, grid[nx][ny]);

                if (newElevation < dist[nx][ny]) {
                    dist[nx][ny] = newElevation;
                    pq.offer(new int[]{newElevation, nx, ny});
                }
            }
        }

        return -1;
    }
}
