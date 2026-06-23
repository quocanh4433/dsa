import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class CourseScheduleII {

    /*

        build graph: O(E)
        Kahn bfs: O(V + E)
        copy List → array: O(V)

        ⇒ time: O(V + E)

        graph: O(E)
        indegree: O(V)
        queue: O(V)
        temp/result: O(V)

        ⇒ space: O(V + E).
     */

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegrees = new int[numCourses];

        for (int[] pre : prerequisites) {
            graph.putIfAbsent(pre[1], new ArrayList<>());
            graph.get(pre[1]).add(pre[0]);
            indegrees[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> temp = new ArrayList<>();

        while (!q.isEmpty()) {
            int cur = q.poll();
            temp.add(cur);

            for (int next : graph.getOrDefault(cur, Collections.emptyList())) {
                indegrees[next]--;

                if (indegrees[next] == 0) {
                    q.offer(next);
                }
            }
        }

        if (temp.size() != numCourses) {
            return new int[0];
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = temp.get(i);
        }

        return res;
    }
}
