package GRAPH.CourseSchedule2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_2_KahnAlgo {
    /**
     
     * Time complexity: O(V + E)
     *
     * Space complexity: O(V + E)
     *
     * V = numCourses E = prerequisites.length
     *
     */

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            // [1 ,0]  0 -> 1
            int u = pre[0]; // 1
            int v = pre[1]; // 0
            graph.get(v).add(u);
        }

        int[] inDegrees = new int[numCourses];
        for (int[] pre : prerequisites) {
            inDegrees[pre[0]]++;
        }

        // BFS
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        // Xử lý môn học không cân tiên quyết trước
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                q.offer(inDegrees[i]);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (int nei : graph.get(node)) {
                inDegrees[nei]--;
                if (inDegrees[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        /*

        🧠 Trong Kahn’s Algorithm, nguyên lý là:
            Mỗi vòng lặp, ta lấy ra 1 môn học có indegree = 0
            Ta "xóa" nó khỏi đồ thị (giảm indegree các môn phụ thuộc)


        Nếu đồ thị không có chu trình (DAG):
            ➡️ Cuối cùng sẽ xóa được hết tất cả các node
            ➡️ ans.size() sẽ bằng numCourses
        */
        // Nếu không học đủ tất cả môn => có cycle

        if (ans.size() != numCourses) {
            return new int[0];
        }

        // Chuyển List -> int[]
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
