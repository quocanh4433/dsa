import java.util.*;

class Solution {

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

        int city = -1; // thành phố cân trả về
        int minReachable = Integer.MAX_VALUE; // số thành phố ít nhất tưng thấy 

        for (int i = 0; i < n; i++) {
            // số thành phố có thể đi tới i
            int count = dijkstra(i, graph, distanceThreshold, n);

            if (count <= minReachable) {
                minReachable = count;
                city = i;
            }
        }

        return city;
    }

    public int dijkstra(int start; List<int[]>[] graph, int distanceThreshold, int n) {
        int[] dist = new int[n]; // dist[i]: khoảng cách ngắn nhất từ start tới i
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

    }
}
