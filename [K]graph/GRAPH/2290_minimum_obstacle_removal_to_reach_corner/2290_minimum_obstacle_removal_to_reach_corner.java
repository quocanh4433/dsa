import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    /*
        tại sao giống dp nhưng không giải theo dp?
            ▪︎ dp không quay lại trạng thái cũ, mỗi ô là trạng thái tối ưu nhất
            ▪︎ bài này, quay lại tráng thái cũ, mỗi ô có thể cập nhật nhiều lần

        time: O((m * n) log(m * n))
        space: O(m * n)
    
     */
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];
        for(int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0, 0}); // {cost, x, y}
        pq.offer(new int[]{0, 0, 0});

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int x = cur[1];
            int y = cur[2];

            if(cost > dist[x][y]) continue;
            if(x == m - 1 && y == n - 1) return cost;

            for(int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                int newCost = cost + grid[nx][ny];

                if(newCost < dist[nx][ny]) {
                    dist[nx][ny] = newCost;
                    pq.offer(new int[]{newCost, nx,ny});
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}