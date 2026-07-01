
import java.util.*;

class Solution_Dijkstra {

    /*
        time: O(n * elogn)
            ▪︎ build graph: O(e)
            ▪︎ duyệt từng node và dijkstra: O(n * elogn)
                ▪︎ duyện qua n node: O(n)
                ▪︎ dijkstra O(elogn)
        space: O(e + n)
            ▪︎ graph: O(e + n)   
            ▪︎ dist[]: O(n)
            ▪︎ pq: O(n) 
     */

    private List<List<int[]>> graph;
    private int n;
    private int distanceThreshold;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        this.n = n;
        this.distanceThreshold = distanceThreshold;
        // build graph
        this.graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(new int[]{e[1], e[2]});
            graph.get(e[1]).add(new int[]{e[0], e[2]});
        }

        int city = -1; // thành phố cần trả về
        int minReachable = Integer.MAX_VALUE; // số thành phố ít nhất tưng thấy 

        for (int i = 0; i < n; i++) {
            // bắt đầu từ i đi qua
            int count = dijkstra(i);

            if (count <= minReachable) {
                minReachable = count;
                city = i;
            }
        }

        return city;
    }

    public int dijkstra(int start) {
        int[] dist = new int[n]; // dist[i]: khoảng cách ngắn nhất từ start tới i
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];

            if (d > dist[u]) {
                continue;
            }

            for (int[] edge : graph.get(u)) {
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
