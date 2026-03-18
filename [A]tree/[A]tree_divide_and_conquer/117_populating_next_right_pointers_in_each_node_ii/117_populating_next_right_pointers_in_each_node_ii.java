
@SuppressWarnings("unused")
class PopulatingNextRightPointersInEachNodeII {

    /*
        time O(n)
        space O(1)

        ý tưởng:
            ▪︎ khó hơn leetcode 116 do mỗi node không chưa đầy đủ left và right
            ▪︎ cần node head để lưu vị trí bắt đầu cho level tiếp theo
            ▪︎ cần node prev giưa node cuôi
    
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }

        Node cur = root;

        while (cur != null) {
            // head: xác định vị trí level tiếp theo
            Node head = null;
            // prev: node trước node đang xét
            Node prev = null;

            while (cur != null) {
                if (cur.left != null) {
                    if (head == null) {
                        head = cur.left;
                    } else {
                        prev.next = cur.left;
                    }
                    prev = cur.left;
                }

                if (cur.right != null) {
                    if (head == null) {
                        head = cur.right;
                    } else {
                        prev.next = cur.right;
                    }
                    prev = cur.right;
                }

                // dich ngang
                cur = cur.next;
            }

            // dich xuông level tiếp theo
            cur = head;
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
