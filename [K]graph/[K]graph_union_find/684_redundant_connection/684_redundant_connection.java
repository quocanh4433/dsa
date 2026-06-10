
class RedundantConnection {
    /*
        time O(n)
            - duyệt edges O(e)
                - ở mỗi edges O(α(n))
            mà đề là e = n -> O(n)
        space O(n)
    */
    private int[] parent;

    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        parent[rootU] = rootV;
    }

    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        this.parent = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if(find(u) == find(v)) {
                return edge;
            }

            union(u, v);
        }

        return new int[0];
    }
}
