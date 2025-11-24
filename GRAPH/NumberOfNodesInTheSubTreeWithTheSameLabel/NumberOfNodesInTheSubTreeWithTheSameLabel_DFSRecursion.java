
import java.util.ArrayList;
import java.util.List;

public class NumberOfNodesInTheSubTreeWithTheSameLabel_DFSRecursion {

    /*
    💡Ý TƯỞNG: 
    Do node cha phải phụ thuộc kết quả node con nên sẽ đi từ node con -> node cha bằng DFS


    Time complexity: O(n * 26) ~ O(n)
    
    Space complexity: O(n)

     */
    private String labels;
    private List<List<Integer>> graph;
    private int[] res;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        this.graph = new ArrayList<>();
        this.res = new int[n];
        this.labels = labels;

        // create adjacency list
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        dfs(0, -1); 
        // Tại sao ý tưởng đi từ lá -> cha nhưng lại bắt đầu từ root ❓
        // 👉 Đi từ root nhưng xử lí từ lá điên lên

        return res;
    }

    public int[] dfs(int node, int parent) {
        int[] count = new int[26];
        int currChar = labels.charAt(node);

        for (int nei : graph.get(node)) {
            if (nei == parent) {
                continue;
            }

            int[] childCount = dfs(nei, node);

            for (int i = 0; i < 26; i++) {
                count[i] += childCount[i];
            }
        }

        // Tăng count của chinh no
        count[currChar - 'a']++;
        // lưu kết quả vào res
        res[node] = count[currChar - 'a'];
        return count;
    }

    public static void main(String[] args) {

    }
}
