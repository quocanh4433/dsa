
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    /*
        time: O(mn log(mn))
        space: O(mn)
    */
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0, 0}); // {cost, x, y}

        int[][] dirs = {
            {0, 1}, // 1 → right
            {0, -1}, // 2 → left
            {1, 0}, // 3 → down
            {-1, 0} // 4 → up
        };

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int x = cur[1];
            int y = cur[2];

            if (cost > dist[x][y]) {
                continue;
            }
            if (x == m - 1 && y == n - 1) {
                return cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }

                /*
                    i tương ứng : i = 0: right, i = 1: leffy, i = 2: down, i = 3: up

                    nhưng y/c: i = 1: right, i = 2: leffy, i = 3: down, i = 4: up

                    nên i + 1
                
                    ý nghia edgeCost

                    nếu mũi tên ở (x, y) trùng với hướng tôi đi thì cost = 0

                    ngược lại cost = 1
                 */
                int edgeCost = (grid[x][y] == i + 1) ? 0 : 1;
                int newCost = cost + edgeCost;

                if (newCost < dist[nx][ny]) {
                    dist[nx][ny] = newCost;
                    pq.offer(new int[]{newCost, nx, ny});
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}
