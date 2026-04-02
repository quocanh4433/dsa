
import java.util.HashMap;
import java.util.Map;


class LFUCache {

    /*
        time 
            - get: O(1)
            - put: O(1)

        space: O(capacity)
     */

    int capacity;
    int minFreq = 0;
    Map<Integer, Node> keyMap = new HashMap<>();
    Map<Integer, DLL> freqMap = new HashMap<>();

    class Node {

        int key;
        int val;
        int freq;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    class DLL {

        Node head;
        Node tail;
        int size;

        DLL() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addFirst(Node node) {
            Node nextNode = head.next;
            head.next = node;
            node.next = nextNode;

            nextNode.prev = node;
            node.prev = head;

            size++;
        }

        void removeNode(Node node) {
            Node nextNode = node.next;
            Node prevNode = node.prev;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }

        Node removeLast() {
            if (size == 0) {
                return null;
            }
            Node node = tail.prev;
            removeNode(node);
            return node;
        }

    }

    public LFUCache(int capacity) {
        this.capacity = capacity;

    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) {
            return -1;
        }
        Node node = keyMap.get(key);
        updateFreq(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.val = value;
            updateFreq(node);
        } else {
            Node node = new Node(key, value);

            if (keyMap.size() == capacity) {
                // remove LFU + LRU
                // xoa node freq ít nhất
                DLL list = freqMap.get(minFreq);
                // nếu có nhiều node cùng freq thì xóa node cũ nhất
                Node lastNode = list.removeLast();

                // xóa trong key map
                keyMap.remove(lastNode.key);
            }

            keyMap.put(key, node);
            freqMap.putIfAbsent(1, new DLL());
            freqMap.get(1).addFirst(node);
            minFreq = 1;
        }
    }

    public void updateFreq(Node node) {
        int oldFreq = node.freq;
        DLL oldList = freqMap.get(oldFreq);

        oldList.removeNode(node);

        // sau khi remove mà level không còn node và level này cung chí là minFreq
        // thì tăng minFreq
        if (oldList.size == 0 && oldFreq == minFreq) {
            minFreq++;
        }

        node.freq++;
        freqMap.putIfAbsent(node.freq, new DLL());
        // trở thành node mới nhất trong level
        freqMap.get(node.freq).addFirst(node);

    }
}
