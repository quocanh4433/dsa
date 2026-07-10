import java.util.ArrayList;
import java.util.List;

class MinCostToConnectAllPoints {

    /*
        Bước	        Time	                Space
        Tạo cạnh	    O(n²)	                O(n²)
        Sắp xếp	        O(n² log n)	            O(1) (ngoài danh sách cạnh)
        Kruskal + DSU	O(n² · α(n)) ≈ O(n²)	O(n)
        Tổng	        O(n² log n)	            O(n²)
     */
    class Edge {

        int u, v, cost;

        Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }

    class DSU {

        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) {
                return false;
            }
            parent[px] = py;
            return true;

        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<Edge> edges = new ArrayList<>();

        // Tạo tất cả các cạnh
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // duyệt cành kề
                int[] p1 = points[i];
                int[] p2 = points[j];
                int cost = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                edges.add(new Edge(i, j, cost));
            }
        }

        // Sắp xếp các trọng số tăng dần
        // để chọn cạnh có chi phí nhỏ nhất trước
        edges.sort((a, b) -> a.cost - b.cost);

        DSU dsu = new DSU(n);

        int ans = 0;
        int edgeUsed = 0;

        for (Edge edge : edges) {
            if (dsu.union(edge.u, edge.v)) {
                ans += edge.cost;
                edgeUsed++;

                if (edgeUsed == n - 1) {
                    break;
                }

            }
        }

        return ans;
    }
}
