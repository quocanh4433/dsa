package GRAPH.CopyListWithRandomPointer;

public class CopyListWithRandomPointer_BestSolution {

    /**
     * Time complexity: O(n)
     *
     * Space complexity: O(1)
     *
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;

        // 1. Đan xen node copy
        while (cur != null) {
            Node copy = new Node(cur.val);
            Node next = cur.next;
            cur.next = copy;
            copy.next = next;

            cur = next;
        }

        // 2. Gán random cho node copy
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                Node copy = cur.next;
                copy.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 3. Tách hai danh sách
        Node dummy = new Node(-1);
        Node curCopy = dummy;
        cur = head;

        /*
        d     -> A -> A' -> B -> B' -> C -> C' -> null
        curCopy  
                cur   
                     copy  next
        
         */
        while (cur != null) {
            Node copy = cur.next;
            Node next = cur.next.next;

            curCopy.next = copy;
            curCopy = copy;

            cur.next = next;
            cur = next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

    }
}

class Node {

    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
