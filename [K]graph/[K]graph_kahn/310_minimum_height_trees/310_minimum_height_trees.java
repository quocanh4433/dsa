
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class MinimumHeightTrees {

    /*
        problem là undirected graph nhưng vẫn áp dung Kahn's Algorithms?
        - nó chỉ mượn ý tưởng từ Kahn's Algorithms

        problem:
        cho danh sách n node bạn có quyền chọn node bất kỳ sao cho tạo thành tree có height thấp nhất
        trả về list các node làm root mà height thấp nhất

        vd: 0 - 1 - 2 - 3 - 4

        chọn root = 0 -> height = 4
        0
         \
          1
           \
            2
             \
              3
               \
                4

        chọn root = 1 -> height = 3
          1
         / \
        0   2
             \
              3
               \
                4

        chọn root = 2 -> height = 2 đây là height nhỏ nhất nên trả về kết quà là [2]
            2
           / \
          1   3
         /     \
        0       4

        
        lưu ý nếu tổng số canh tức n - 1 là số lẻ thì có 2 root thỏa điều kiện      
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                q.offer(i);
            }
        }

        int remainNode = n;

        while (remainNode > 2) { // vì chỉ có thể lấy tối đa 2 node làm root
            int size = q.size();
            remainNode -= size;

            for (int i = 0; i < size; i++) {
                int leaf = q.poll();
              
            }

        }

        return null;
    }
}
