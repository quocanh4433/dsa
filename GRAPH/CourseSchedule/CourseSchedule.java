package GRAPH.CourseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    /**
     * BẢN CHẤT CỦA BÀI TOÁN
     * Bài này quy về bài toán đồ thị:
     * Mỗi môn học = 1 đỉnh (vertex)
     * Mỗi điều kiện [a, b] = 1 cạnh có hướng b → a
     * ➡ Bài toán trở thành: Kiểm tra đồ thị có hướng có chu trình hay không.
     * 
     * 👉 DFS
     * 👉 BFS (Kahn's Algorithm)
     * 👉 Hay Union-Find?
     * 
     * 
     * Time complexity: O(n + e)
     * 
     * Space complexity: O(n + e)
     * 
    */

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // create adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites) {
            int a = pre[0]; 
            int b = pre[1];
            graph.get(b).add(a); // b -> a
        }

        // create array indegree: số điều kiện tiên quyết còn tồn tại để học môn i   
        // b → a
        // Vậy inDegree[a] = số môn phải học trước a mà chưa học   
        int[] inDegree = new int[numCourses];
        for(int[] pre : prerequisites) {
            inDegree[pre[0]]++;
        }

        // Bắt đầu từ những môn không cần tiên quyết
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) q.offer(i);
        }

        // Đếm số node đã xử lý
        int count = 0; 

        while(!q.isEmpty()) {
            int node = q.poll();
            count++;
            for(int nei : graph.get(node)) {
                inDegree[nei]--;
                if(inDegree[nei] == 0) q.offer(nei);
            }
        }   

        // Nếu count == numCourses → không có chu trình
        return count == numCourses;
    }


    public static void main(String[] args) {
        
    }
}
