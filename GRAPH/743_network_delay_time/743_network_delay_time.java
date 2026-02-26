
import java.util.*;

class Solution {
    /*
        time: O(elogv)
        space: O(e + v)
    */

    public int networkDelayTime(int[][] times, int n, int k) {
        // build graph adjacency list
        // tại sao n + 1? Vì các cạnh bắt đầu từ 1 - n
        
        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] t : times) {
            graph[t[0]].add(new int[]{t[1], t[2]});
        }

        // thời gian ngắn nhất đi đến node i
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // ví trí bắt đầu k
        dist[k] = 0;

        // min-heap chứa [time, node] sắp xếp time tăng dần
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, k}); // bắt đầu từ node k với thời gian = 0

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0];
            int node = cur[1];

            // 🔥 Dòng CỰC KỲ QUAN TRỌNG
            // vì 1 node có thể push vào heap nhiều lần
            // thơi gian hiện tại không tối ưu thì bỏ qua
            if (time > dist[node]) {
                continue;
            }

            // lấy ra các node kề với node hiện tại
            for (int[] next : graph[node]) {
                int v = next[0];
                int w = next[1];

                // nếu tìm được được đi ngắn nhât từ node tới v
                if (dist[v] > time + w) {
                    dist[v] = time + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}
