
class AllOne {

    class Node {

        String key;
        int freq;
        Node prev;
        Node next;

        Node(String _key) {
            key = _key;
            prev = null;
            next = null;
            freq = 1;
        }
    }

    class DLL {

        Node head = new Node("-1");
        Node tail = new Node("-1");
        int size;

        DLL() {
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

        String getFirst() {
            return head.next.key;
        }
    }

    Map<String, Node> keyMap = new HashMap<>();
    Map<Integer, DLL> freqMap = new HashMap<>();

    int minFreq = 0;
    int maxFreq = 0;

    public AllOne() {

    }

    public void inc(String key) {
        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            incFreq(node);
        } else {
            Node node = new Node(key);
            keyMap.put(key, node);
            freqMap.putIfAbsent(1, new DLL());
            freqMap.get(1).addFirst(node);
            minFreq = 1;
            maxFreq = Math.max(maxFreq, 1);
        }
    }

    public void dec(String key) {
        if (!keyMap.containsKey(key)) {
            return;
        } else {
            Node node = keyMap.get(key);
            descFreq(node);
        }
    }

    public String getMaxKey() {
        if (keyMap.isEmpty()) {
            return "";
        }
        DLL list = freqMap.get(maxFreq);
        return list.getFirst();
    }

    public String getMinKey() {
        if (keyMap.isEmpty()) {
            return "";
        }
        DLL list = freqMap.get(minFreq);
        return list.getFirst();
    }

    public void incFreq(Node node) {
        int oldFreq = node.freq;
        DLL oldList = freqMap.get(oldFreq);

        oldList.removeNode(node);

        if (oldList.size == 0 && oldFreq == minFreq) {
            minFreq++;
            maxFreq = Math.max(maxFreq, minFreq);
        }

        node.freq++;
        freqMap.putIfAbsent(node.freq, new DLL());
        freqMap.get(node.freq).addFirst(node);
    }

    public void descFreq(Node node) {
        int oldFreq = node.freq;
        DLL oldList = freqMap.get(oldFreq);

        oldList.removeNode(node);

        if (oldList.size == 0 && oldFreq == maxFreq) {
            maxFreq--;
            minFreq = Math.min(minFreq, maxFreq);
        }

        node.freq--;
        if (node.freq == 0) {
            keyMap.remove(node.key);
        } else {
            freqMap.putIfAbsent(node.freq, new DLL());
            freqMap.get(node.freq).addFirst(node);
        }
    }
}
