package GRAPH.CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer_HashMap {
    /**
     * Time complexity: O(n)
     * 
     * Space complexity: O(n)
     * 
     */


    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;

        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while(cur != null) {
            Node copyNode = map.get(cur);
            copyNode.next = map.get(cur.next); 
            copyNode.random = map.get(cur.random); 
            cur = cur.next;
        }
        
        return map.get(head);
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
