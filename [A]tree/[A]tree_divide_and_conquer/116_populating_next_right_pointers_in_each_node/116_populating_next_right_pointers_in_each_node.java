
@SuppressWarnings("unused")
class PopulatingNextRightPointersInEachNode {

    /*
        time O(n)
        space (1)

        phù hợp cho interview

        tóm tăt: 
            ▪︎ mỗi node là instant của class Node có left, right, next
            ▪︎ left, right đã có thông tin, tìm next ?? cho mỗi node


             1
           /   \
          2     3
         / \   / \
        4   5 6   7


        ý tưởng: dùng next duyệt ngang từ trái -> phải
            ▪︎ node left nối với node right trên cùng level: node.left.next = node.right;
                ▪︎ vd: node 2 nối với node 3
            ▪︎ node right nối với node left nhánh kề: node.right.next = root.next.left
                ▪︎ vd: node 5 nối với node 6 của nhánh kế bên
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node level = root;

        // nếu node root không có node con thì không cần làm gì
        // tại sao chỉ kiểm tra left? do là perfect binary tree có đủ 2 node con hoặc không có node nào
        while (level.left != null) {
            Node cur = level;

            while (cur != null) {
                // nối node con left vơi node con right
                cur.left.next = cur.right;

                // kiểm tra node cha có node a/e hay không
                // nếu node cha có node a/e
                // thì node con right của node cha   với    node con left của node a/e node cha
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }

                cur = cur.next;
            }

            // xuống level bên dươi
            level = level.left;
        }

        return root;
    }
}

class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
