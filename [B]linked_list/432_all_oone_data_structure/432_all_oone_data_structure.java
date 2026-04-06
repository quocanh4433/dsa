
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class AllOne {

    class Node {

        Node prev;
        Node next;
        Set<String> keys = new HashSet<>();
        int count;

        Node() {
            this("-1", 0);
        }

        Node(String key, int count) {
            this.keys.add(key);
            this.count = count;
        }

        // insert immediately after this node
        // sentinel.insertAfter(newNode) -> this node: sentinel
        Node insertAfter(Node node) {
            Node nextNode = this.next;
            Node prevNode = this.prev;

            this.next = node;
            node.next = nextNode;
            nextNode.prev = node;
            node.prev = prevNode;

            return node;
        }
    }

    Map<String, Node> keyMap;
    Node sentinel;

    public AllOne() {
        keyMap = new HashMap<>();
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void inc(String key) {
        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            int newCount = node.count + 1;

            if (sentinel.next == sentinel || sentinel.next.count > newCount) {
                // doubly-linkedlist đang rỗng || node nhỏ nhất lớn hơn newcount -> nối với sentinel
                Node newNode = new Node(key, newCount);
                keyMap.put(key, sentinel.insertAfter(newNode));
            } else {
                sentinel.next.keys.add(key);
                keyMap.put(key, sentinel.next);
            }

        } else {
            if (sentinel.next == sentinel || sentinel.next.count > 1) {
                // doubly-linkedlist đang rỗng || node nhỏ nhất không phải count = 1
                Node newNode = new Node(key, 1);
                keyMap.put(key, sentinel.insertAfter(newNode));
            } else {
                // A node with count 1 already exists
                sentinel.next.keys.add(key);
                keyMap.put(key, sentinel.next);
            }

        }
    }

    public void dec(String key) {

    }

    public String getMaxKey() {
        return "";
    }

    public String getMinKey() {
        return "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such: AllOne obj = new
 * AllOne(); obj.inc(key); obj.dec(key); String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
// public static void main(String[] args) {
//     AllOne ao = new AllOne();
//     ao.inc("a");
//     ao.inc("b");
//     ao.inc("b");
//     ao.inc("c");
//     ao.inc("c");
//     ao.inc("c");
//     ao.dec("b");
//     ao.dec("b");
//     System.out.println(ao.getMinKey());
//     ao.dec("a");
//     System.out.println(ao.getMaxKey());
//     System.out.println(ao.getMinKey());
// }
