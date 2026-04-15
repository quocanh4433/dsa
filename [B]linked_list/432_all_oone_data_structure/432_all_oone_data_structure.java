
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class AllOne {
    /*
        ý tưởng:
            ▪︎ lưu key có cùng count sẽ nằm cùng Node

            ▪︎ các Node nối với nhau theo doubly linked-list

            ▪︎ lưu theo doubly linked-list để getMax() và getMin() trong O(1), 
            bằng cách max là sentinel.prev và min là sentinel.next 

            ▪︎ sử dụng hashmap (key: key - value: Node chứa key) để truy xuất count theo key O(1)
    */



    class Node {
        Node prev;
        Node next;
        Set<String> keys = new HashSet<>();
        int count;

        Node() {
            this("-1", 0);
        }

        Node (String key, int count) {
            this.keys.add(key);
            this.count = count;
        }

        // insert immediately after this node
        // sentinel.insertAfter(newNode) -> this node: sentinel
        Node insertAfter(Node node) {
            Node nextNode = this.next;
            this.next = node;
            node.next = nextNode;
            nextNode.prev = node;
            node.prev = this;

            return node;
        }

        void remove() {
            Node nextNode = this.next;
            Node prevNode = this.prev;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;
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
        if(keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            Node nextNode = node.next;
            int newCount = node.count + 1;

            if(nextNode == sentinel || nextNode.count > newCount ) {
                // doubly-linkedlist đang rỗng || node nhỏ nhất lớn hơn newcount -> nối với sentinel
                Node newNode = new Node(key, newCount);
                keyMap.put(key, node.insertAfter(newNode));
            } else {
                nextNode.keys.add(key);
                keyMap.put(key, nextNode);
            }

            node.keys.remove(key);
            if (node.keys.isEmpty()) {
                node.remove();
            }

        } else {
            if(sentinel.next == sentinel || sentinel.next.count > 1) {
                // doubly-linkedlist đang rỗng || node nhỏ nhất không phải count = 1
                Node newNode = new Node(key, 1);
                keyMap.put(key, sentinel.insertAfter(newNode)); // insert newNode ngay sau sentinel (sentinel.next = newNode)
            } else {
                // A node with count 1 already exists
                sentinel.next.keys.add(key);
                keyMap.put(key, sentinel.next);
            }
        }
    }
    
    public void dec(String key) {
        if(!keyMap.containsKey(key)) return;

        Node node = keyMap.get(key);
        int newCount = node.count - 1;

        if(newCount == 0) {
            keyMap.remove(key);
        } else {
            Node prevNode = node.prev;

            if(prevNode == sentinel || prevNode.count < newCount ) {
                // case 1: prevNode là head không còn node với count nhỏ hơn
                // case 2: sức chứa của prevNode nhỏ hơn sức chứa mong muốn

                // tạo bucket mới
                Node newNode  = new Node(key, newCount);
                keyMap.put(key, prevNode.insertAfter(newNode));
            } else {
                prevNode.keys.add(key);
                keyMap.put(key, prevNode);
            }
        }

        node.keys.remove(key);
        if(node.keys.isEmpty()) {
            node.remove();
        }
    }
    
    public String getMaxKey() {
        if(sentinel.prev == sentinel) return "";
        return sentinel.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        if(sentinel.next == sentinel) return "";
        return sentinel.next.keys.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */