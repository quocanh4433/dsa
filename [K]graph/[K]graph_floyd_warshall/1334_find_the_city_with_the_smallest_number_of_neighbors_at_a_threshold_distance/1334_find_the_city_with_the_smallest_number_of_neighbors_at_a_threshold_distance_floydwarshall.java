
import java.util.Arrays;

class Solution_Floyd {

    /*
        - matrix O(n**2)
        - build graph O(e)
        - floydwarshall O(n**3)
        -> time: O(n**3)


        - dist[][] O(n**2)
        - another variable O(1)
        -> space: O(n**2)
    
     */
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF = Integer.MAX_VALUE;
        int[][] dist = new int[n][n];

        // initialize
        for (int i = 0; i < n; i++) {
            // thêm cho từng hàng
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            dist[u][v] = w;
            dist[v][u] = w;
        }

        // floyd-warshall
        for (int k = 0; k < n; k++) { // k là node trung gian ở giữa i và j
            for (int i = 0; i < n; i++) { // i là node bắt đầu
                for (int j = 0; j < n; j++) { // j là node kết thúc
                    if (dist[i][k] == INF || dist[k][j] == INF) {
                        // nếu không đi được từ i đến k hoặc không đi được từ k đến j, 
                        // thì không thể đi từ i đến j thông qua k.
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // result
        int city = -1;
        int minReachable = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    // đếm xem từ thành phố i có thể đi đến bao nhiêu thành phố khác với khoảng cách không vượt quá distanceThreshold.
                    count++;
                }
            }

            if (count <= minReachable) {
                city = i;
                minReachable = count;
            }
        }

        return city;
    }

}
