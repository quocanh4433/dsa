package GRAPH.NumberOfProvinces;

public class NumberOfProvinces_UnionFind {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {// chỉ cần đi nửa trên
                // Tai sao chỉ đi nửa trên ❓
                // vì ma trận là đối xứng (isConnected[i][j] == isConnected[j][i]).
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.getCount();

    }

    public static void main(String[] args) {

    }
}

class UnionFind {

    private int[] parent;
    private int[] rank;
    private int count;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        this.count = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int findParent(int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = findParent(x);
        int rootY = findParent(y);

        if (rootX == rootY) {
            return;
        }

        // Union by rank
        if(rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
            rank[rootY]++;
        }

        count--;

    }

    public int getCount() {
        return count;
    }
}
