
import java.util.HashMap;
import java.util.Map;

class LRUCache {
    /*  
        time
            - get(): O(1)
            - put(): O(1)
        space O(capacity)
     */
    int capacity;
    Map<Integer, Node> map = new HashMap<>(); // key: node's val - value: Node
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            next = null;
            prev = null;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node n = map.get(key);
        update(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            n.val = value;
            update(n);
        } else {
            Node n = new Node(key, value);
            if(map.size() == capacity) {
                // deleteting the last node in the linkedlist
                Node lastNode = tail.prev;
                delete(lastNode);
                map.remove(lastNode.key);
            }
            map.put(key, n);
            add(n);
        }
    }

    public void add(Node n) {
        Node nextNode = head.next;
        head.next = n;
        n.next = nextNode;
        nextNode.prev = n;
        n.prev = head;
    }

    public void delete(Node n) {
        Node prevNode = n.prev;
        Node nextNode = n.next;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void update(Node n) {
        delete(n);
        add(n);
    }
}
