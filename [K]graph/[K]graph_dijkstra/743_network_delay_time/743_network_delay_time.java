
import java.util.*;

class Solution {
    /*
        n: node
        e: edge

        - build graph O(n + e)
        - dist O(n)
        - heap O(nlogn)

        -> time O((n + e)logn)


        - graph O(n + e)
        - dist O(n)
        - pq O(e) tại sao không phải O(n)
            - do mỗi edge gây ra 1 lân push

        -> space O(n + e)
    
     */


    public int networkDelayTime(int[][] times, int n, int k) {
        // build graph adjacency list
        // tại sao n + 1? Vì các cạnh bắt đầu từ 1 - n
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.get(u).add(new int[]{v, w});
        }

        int[] dist = new int[n + 1]; // dist[i] = khoang cach ngan nhattu node k den node i
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        // min_heap<[time, node]> time is increased
        // Integer.compare tranhs int overflow
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0];
            int node = cur[1];
            
            // 🔥 Dòng CỰC KỲ QUAN TRỌNG
            // vì 1 node có thể push vào heap nhiều lần
            // thơi gian hiện tại không tối ưu thì bỏ qua
            if(time > dist[node]) continue;

            for(int[] next : graph.get(node)) {
                int v = next[0];
                int w = next[1];

                if(time + w < dist[v]) { // phát hiện khoảng thời igan khác nhơ hơn thời gian hiện tại
                    dist[v] = time + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }

        }

        int ans = 0;

        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]); // lấy node nhận tín hiệu chậm nhất
        }

        return ans;
    }
}
