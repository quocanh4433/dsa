import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class FindEventualSafeStates {

    /*
        - buiild reverse graph O(N + E)
        - add queue O(N)
        - Kahn dfs O(N + E)
        time: O(N + E)

        - list Rev O(N + E)
        - queue O(N)
        - outdegrees O(N)
        - res O(N)
        space: O(N + E)
    
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> rev = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            rev.add(new ArrayList<>());
        }

        int[] outdegrees = new int[n];

        // build reverse graph
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                rev.get(v).add(u);
                outdegrees[u]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        // terminal nodes in original graph
        for (int i = 0; i < n; i++) {
            if (outdegrees[i] == 0) {
                q.offer(i);
            }
        }

        boolean[] safe = new boolean[n];

        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;

            for (int prev : rev.get(node)) {
                outdegrees[prev]--;

                if (outdegrees[prev] == 0) {
                    q.offer(prev);
                }
            }
        }

        // sử dụng mảng safe để tránh sort res
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                res.add(i);
            }
        }

        return res;
    }
}
