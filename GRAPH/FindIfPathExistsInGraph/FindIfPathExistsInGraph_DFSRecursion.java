
import java.util.ArrayList;
import java.util.List;

public class FindIfPathExistsInGraph_DFSRecursion {

    /**
     * Time complexity: O(n + e), n: node - e :edge
     *
     * Space complexity: O(n + e), n: node - e :edge
     */
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Create adjacency injection
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Create edges
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        return dfs(graph, visited, source, destination);
    }

    public boolean dfs(List<List<Integer>> graph, boolean[] visited, int node, int destination) {
        if (node == destination) {
            return true;
        }
        visited[node] = true;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                if(dfs(graph, visited, next, destination)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
