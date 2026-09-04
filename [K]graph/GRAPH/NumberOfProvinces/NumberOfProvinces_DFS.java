package GRAPH.NumberOfProvinces;

public class NumberOfProvinces_DFS {

    /**
     * Time complexity: O(n^2)
     * 
     * Space cimplexity: O(n)
    */


    public int findCircleNum(int[][] isConnected) {
        /*
        IDEA:
        - arr vistied để theo dõi node 
         */
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            res++;
            dfs(visited, isConnected, i);
        }

        return res;
    }

    public void dfs(boolean[] visited, int[][] isConnected, int cur) {
        visited[cur] = true;

        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] || isConnected[cur][i] == 0) {
                continue;
            }
            dfs(visited, isConnected, i);
        }
    }
    
    public static void main(String[] args) {
        
    }
}
