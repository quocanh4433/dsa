/*

KHÔNG KHUYÊN DÙNG BFS CHO BÀI NÀY
s
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class NumberOfNodesInTheSubTreeWithTheSameLabel_BFS {

    /* CHƯA GIẢI XONG */

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> graph = new ArrayList<>();
        // create adjacency list
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // BFS
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[n];
        Arrays.fill(result, 1);
        q.offer(0);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nei : graph.get(cur)) {
                if (labels.charAt(cur) == labels.charAt(nei)) {
                    result[cur] += 1;
                    result[nei] += 1;
                    q.offer(nei);
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        
    }
}
