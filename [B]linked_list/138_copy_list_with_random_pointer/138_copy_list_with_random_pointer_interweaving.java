

@SuppressWarnings("unused")
class CopyListWithRandomPointer_Interweaving {

    /*
        time O(n)
        space O(1)

        interweaving

        A -> B -> C
        A -> A' -> B -> B' -> C -> C'
    
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // insert clone node
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        // handle random
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                /*
                    A random đến C

                    A' (cur.next.random) trỏ tới node C' (cur.random.next)

                 */
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // split
        Node dummy = new Node(0);
        Node prev = dummy;
        cur = head;

        while (cur != null) {
            Node copy = cur.next;

            prev.next = copy;
            prev = copy;

            cur.next = copy.next;
            cur = cur.next;
        }

        return dummy.next;
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
