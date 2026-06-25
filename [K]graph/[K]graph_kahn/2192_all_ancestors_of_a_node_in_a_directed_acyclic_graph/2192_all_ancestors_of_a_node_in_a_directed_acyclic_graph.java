import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class AllAncestorsOfANodeInADirectedAcyclicGraph {

    /*
        - xây graph + indegree   O(m)
        - duyệt ancestor         O(n)
        - kahn algo: 
            Khởi tạo queue:      O(n)
            Kahn traversal:      O(n + m)
            add + addAll:        O(n²)
            -> Kahn              O(n²)
        - sort result            O(n² log n)
        
        -> time:                 O(n² log n)


        - graph + indegree       O(n + m)
        - ancestors              O(n²)
        
        -> space: O(n²)
     */
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 1) {
            res.add(new ArrayList<>());
            return res;
        };

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            indegree[v]++;
        }

        List<Set<Integer>> ancestors = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ancestors.add(new HashSet<>());
        }

        Queue<Integer> q = new LinkedList<>();

        for (int node = 0; node < n; node++) {
            if (indegree[node] == 0) {
                q.offer(node);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : graph.get(u)) {
                ancestors.get(v).add(u);
                ancestors.get(v).addAll(ancestors.get(u));
                indegree[v]--;

                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }

        }

        List<List<Integer>> result = new ArrayList<>();

        for (Set<Integer> set : ancestors) {
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            result.add(new ArrayList<>(list));
        }

        return result;
    }
}
