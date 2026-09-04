package GRAPH.KeysAndRooms;

import java.util.List;

public class KeysAndRooms {

    /**
     * Time complexity: O(V + E)
     * 
     * Space complexity: O(V)
     * 
     * 
     */

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        dfs(0, visited, rooms);

        for (boolean v : visited) {
            if (v == false) {
                return false;
            }
        }
        return true;
    }

    public void dfs(int cur, boolean[] visited, List<List<Integer>> rooms) {
        visited[cur] = true;
        List<Integer> keys = rooms.get(cur);

        // Bỏ dòng này
        // if(cur == rooms.size() - 1) return 

        for (int key : keys) {
            if (!visited[key]) { // Lỗi tiềm ẩn gây stackoverflow
                dfs(key, visited, rooms);
            }
        }

    }
    public static void main(String[] args) {
        
    }
}
