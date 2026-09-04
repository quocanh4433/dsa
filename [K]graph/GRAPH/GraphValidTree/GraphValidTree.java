package GRAPH.GraphValidTree;

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree {

    /**
     * Given n nodes labeled from 0 to n - 1 and a list of undirected edges
     * (each edge is a pair of nodes), write a function to check whether these
     * edges make up a valid tree.
     *
     * Một graph (đồ thị) là một cây (tree) nếu nó thỏa 2 điều kiện: 1.
     * Connected (liên thông): Có đường đi giữa mọi cặp đỉnh. 2. Acyclic (không
     * có chu trình): Không có vòng lặp nào trong graph.
     *
     *
     * Time complexity: O(n)
     *
     * Space complexity: O(n)
     */

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        if (!dfs(graph, visited, 0, -1)) {
            return false;
        }

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(List<List<Integer>> graph, boolean[] visited, int node, int parent) {
        visited[node] = true;
        for (int nei : graph.get(node)) {
            if (nei == parent) {
                continue;
            }
            if (visited[nei]) {
                return false;
            }
            if (!dfs(graph, visited, nei, node)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
