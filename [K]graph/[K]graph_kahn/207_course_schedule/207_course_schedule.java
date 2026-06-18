import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CourseSchedule {
    /*
        n: numCourses
        e: len(prerequisites)

        time O(n + e)
        space O(n + e) 
            - graph: O(n + e)
            - indegree: O(n)
            - queue: O(n)
    
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int a = pre[0];
            int b = pre[1];
            graph.get(b).add(a); // graph[b]: {a, ...} cho biết b là môn tiên quyết của các môn trong mảng
        }

        // tìm số lượng các môn tiên quyết
        // indegree[a] = 5 cho biết đề học được a cần học 5 môn tiên quyết
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0; // đếm số node đã xử lí

        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;

            for (int nei : graph.get(curr)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        return count == numCourses;
    }
}
