
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindIfPathExistsInGraph_BFS {

    /**
     * Time complexity: O(n + e), n: node - e :edge
     * 
     * Space complexity: O(n + e), n: node - e :edge
     * 
     *
     * */ 

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Tạo adjacency list
        List<List<Integer>> graph = new ArrayList<>(); // space: O(n + e)
        for (int i = 0; i < n; i++) { // Time: O(n)
            graph.add(new ArrayList<>());
        }

        // Dien vao graph
        for (int[] e : edges) { // Time: O(e)
            int u = e[0];
            int v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u); // dồ thị vô hướng
        }

        // BFS
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n]; // space: O(n)

        q.offer(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            // Nếu chạm destination => có đường đi
            if (node == destination) {
                return true;
            }

            for (int nei : graph.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.offer(nei);
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {

    }
}
