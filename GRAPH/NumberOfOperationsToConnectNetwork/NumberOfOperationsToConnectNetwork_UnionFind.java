package GRAPH.NumberOfOperationsToConnectNetwork;

/*
SOLUTION: Union-Find

 */
public class NumberOfOperationsToConnectNetwork_UnionFind {

    /**
     *
     * m = connections.length.
     *
     * Time complexity: O(n + m * α(n)) ≈ O(n + m)
     *
     * Space complexity: O(n)
     */
    class UnionFind {

        private int[] parent;
        private int[] rank; // optional để tối ưu

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) {
                return false; // cùng component
            }
            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }

            return true;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        // Không đủ cáp để kết nối tất cả máy tính
        if (connections.length < n - 1) {
            return -1;
        }

        UnionFind uf = new UnionFind(n);
        int component = n;
        for (int[] conn : connections) {
            if (uf.union(conn[0], conn[1])) {
                component--;
            }
        }

        return component - 1; // cần n - 1 thao tác
    }

    public static void main(String[] args) {

    }
}
