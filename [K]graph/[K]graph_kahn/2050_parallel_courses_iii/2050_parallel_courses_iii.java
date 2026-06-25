import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ParallelCoursesIII {

    /*
        time O(m + n)
        space O(m + n)

        n = số course
        m = số relation
     */
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] re : relations) {
            int u = re[0];
            int v = re[1];
            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] finishTime = new int[n + 1];

        for (int node = 1; node <= n; node++) {
            if (indegree[node] == 0) {
                q.offer(node);
                finishTime[node] = time[node - 1];
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : graph.get(u)) {

                finishTime[v] = Math.max(finishTime[v], finishTime[u] + time[v - 1]);

                indegree[v]--;

                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, finishTime[i]);
        }

        return result;
    }
}
