import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
class CopyListWithRandomPointer_HashMap {

    /*
        time O(n)
        space O(n)

        key's map should use reference type
    
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new Node(head.val);
        }

        // build map
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node newNode = map.get(cur);
            newNode.next = map.get(cur.next);
            newNode.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
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
