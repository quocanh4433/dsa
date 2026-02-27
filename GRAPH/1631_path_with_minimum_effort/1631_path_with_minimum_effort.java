
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    /*
        time: O((m * n) log(m * n))
            ▪︎ priorityQueue poll() pop(): O(log(m * n))
            ▪︎ loop: O(n * m)
        space O(m * n)
            ▪︎ priorityQueue: O(m * n)
            ▪︎ variable: O(1)
    
    */
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        // dist[x][y]: min effort from (0, 0) to (x,y)
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // min-heap lưu giá trị thấp nhất của effort 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0, 0});  // {effort, r, c}

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int effort = cur[0];
            int r = cur[1];
            int c = cur[2];

            if (r == m - 1 && c == n - 1) {
                return effort;
            }
            if (effort > dist[r][c]) {
                continue;
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n) {
                    continue;
                }

                int nextEffort = Math.max(effort, Math.abs(heights[r][c] - heights[nr][nc]));

                if (nextEffort < dist[nr][nc]) {
                    dist[nr][nc] = nextEffort;
                    pq.offer(new int[]{nextEffort, nr, nc});
                }
            }

        }

        return 0;
    }
}
