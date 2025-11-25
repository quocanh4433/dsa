
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

                // 01. Lấy ra node clone từ node original (Node cur)
                Node cloneNode = oldToNew.get(cur);

                // 02. Lấy ra node neighbor tư node neighbor original
                // Node nei này được thêm từ điều kiện if ở trên 
                Node neiNode = oldToNew.get(nei);

                // 03. Kết nối node clone hiện tại với node clone neighbor
                cloneNode.neighbors.add(neiNode);

                // Từ 01, 02, 03 ở trên có thể viết gọn thành
                // oldToNew.get(cur).neighbors.add(oldToNew.get(nei));
            }
        }

        return oldToNew.get(node);
    }

    /**
     * REVISE - FIRST TIME
     */
    public Node cloneGraph_reviseFirstTime(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> origToClone = new HashMap<>(); // pair of key: original Node - value: clone Node
        Queue<Node> q = new LinkedList<>();

        q.add(node);
        origToClone.put(node, new Node(node.val));

        while (!q.isEmpty()) {
            Node origNode = q.poll();

            // Clone neighbors
            for (Node nei : origNode.neighbors) {
                if (!origToClone.containsKey(nei)) {
                    origToClone.put(nei, new Node(nei.val));
                    q.add(nei);
                }

                // Get clone node
                Node cloneNode = origToClone.get(origNode);

                // Get nei for clone node
                Node cloneNei = origToClone.get(nei);

                // Add neighbor for clone node
                cloneNode.neighbors.add(cloneNei);
            }

        }

        return origToClone.get(node); // get clone node
    }

    /**
     * REVISE - SECOND TIME
     */
    public Node cloneGraph_reviseSecondTime(Node node) {
        // ❌: thiếu kiêm tra điều kiện null
        if(node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(Node nei : cur.neighbors) {
                if(!map.containsKey(nei)) {
                    map.put(nei, new Node(nei.val));
                    q.add(nei);
                }

                // ❌: get(cur)     và       get neiClone từ map không phải tạo nei.val mới
                // map.get(node).neighbors.add(new Node(nei.val));

                // ✅
                map.get(node).neighbors.add(map.get(nei));
            }
        }

        return map.get(node);
    }
    

    /*
     * DEPTH FIRST SEARCH
     * 
     * 
     */
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
