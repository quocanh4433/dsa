
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    /*
     * BREATH FIRST SEARCH
     * 
     * Time complexity: O(N + E)
     * 
     * Space complexity: O(N)
     * 
     * 
     * 💡 Ý tưởng:
     * - Hashmap với [key: node - value: node*]. Trong dó node* là node mới (khác reference) nhưng có value và neighbors giống với node.
     * - Queue chứa node đã duyêt qua.
     * - Duyệt qua node trong queue -> duyệt qua neighbor của từng node
     *      - Nếu nei chưa có trong map -> add vào amp và queue
     *      - Nếu nei đã có trong map -> tạo neighbor cho node
     * 
     * 
     * 🧩 Tại sao sư dụng hashmap mà không sử dụng recursion?
     * Vì graph có thể có vòng (cycle), nếu ta clone bằng cách tạo node mới rồi đệ quy luôn, sẽ bị lặp vô hạn.
     * 
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> oldToNew = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        // Tạo node clone nhưng chưa có neighbors
        oldToNew.put(node, new Node(node.val));
        q.add(node);

        // Tạo neighbors
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (Node nei : cur.neighbors) {
                if (!oldToNew.containsKey(nei)) {
                    oldToNew.put(nei, new Node(nei.val));
                    q.add(nei);
                }

                // kết nối node clone hiện tại với node clone neighbor
                oldToNew.get(cur).neighbors.add(oldToNew.get(nei));
            }
        }

        return oldToNew.get(node);
    }
}

class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
