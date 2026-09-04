package GRAPH.MinimumNumberOfVerticesToReachAllNodes;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {
    /*
    💡 Ý TƯỞNG

    Đồ thị có hướng (DAG hoặc không có yêu cầu chu trình).

    Một node không có cạnh đi vào (in-degree = 0) là node bắt buộc phải chọn.

    Nếu không chọn, không có cách nào đi tới nó từ node khác.

    Các node còn lại có in-degree > 0 đã có đường đi từ node khác, không cần thêm vào tập xuất phát.


    Time complexity: O(n + e)

    Space complexity: O(n)

    
    */

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegree = new int[n];

        // Tính in-degree cho tất cả các node
        for (List<Integer> e : edges) {
            int to = e.get(1);
            inDegree[to]++;
        }

        // Tập node tối thiểu = tất cả các node có in-degree = 0
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                res.add(i);
            }
        }

        return res;
    }

    /*
        Bài này có thể làm theo BFS/ DFS nhưng độ phức tạp tăng lên
    */

    public static void main(String[] args) {

    }
}
