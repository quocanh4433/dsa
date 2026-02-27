import java.util.*;

class Solution {
    /*
        time: O(n * elogn)
            ▪︎ build graph: O(e)
            ▪︎ dijkstra: O(elogn)
            ▪︎ duyện qua n node: O(n)
        space: O(e + n)
            ▪︎ graph: O(e + n)   
            ▪︎ dist[]: O(n)
            ▪︎ pq: O(n) 
    */

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // build graph
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }

        int city = -1; // thành phố cần trả về
        int minReachable = Integer.MAX_VALUE; // số thành phố ít nhất tưng thấy 

        for (int i = 0; i < n; i++) {
            // số thành phố có thể đi bất đầu từ i thỏa điều kiện distanceThreshold
            int count = dijkstra(i, graph, distanceThreshold, n);

            // tại sao điều kiện là <= mà không phải < ?
            if (count <= minReachable) { 
                minReachable = count;
                city = i;
            }
        }

        return city;
    }

    public int dijkstra(int start, List<int[]>[] graph, int distanceThreshold, int n) {
        int[] dist = new int[n]; // dist[i]: khoảng cách ngắn nhất từ start tới i
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];

            if (d > dist[u]) continue;

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i != start && dist[i] <= distanceThreshold) {
                count++;
            }
        }
        return count;
    }
}
