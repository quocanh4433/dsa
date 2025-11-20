
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindIfPathExistsInGraph_DFSIterative {

    /**
     * Time complexity: O(n + e), n: node - e :edge
     * 
     * Space complexity: O(n + e), n: node - e :edge
     * 
     *
     * */ 

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;

        // Create adjacency injection
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Create edges
        for(int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // DFS
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];

        stack.add(source);
        visited[source] = true;

        while(!stack.isEmpty()) {
            int node = stack.pop();

            if(node == destination) return true;

            for(int next : graph.get(node)) {
                if(!visited[next]) {
                    stack.add(next);
                    visited[next] = true;
                }
            }

        }
        return false;
    }
    public static void main(String[] args) {

    }
}
