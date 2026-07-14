
class MyHashMap {

    /*
    
    add() 
        time: O(1) - worst case: O(n)
    
    contains() 
        time: O(1) - worst case: O(n)
    
    remove() 
        time: O(1) - worst case: O(n)

    worstcase khi tất cả key dồn chung 1 bucket

    space:
        - mảng set: O(SIZE)
        - mỗi key 1 node -> n key -> O(n)
        -> O(SIZE + n) = O(n) 🔹
    


     */

    class Node {

        int val;
        int key;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int SIZE = 10000;
    private final Node[] bucket;

    public MyHashMap() {
        bucket = new Node[SIZE];
    }

    public int getIndex(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        Node head = bucket[index];
        Node cur = head;

        // kiểm tra key đã có trong bucket
        while (cur != null) {
            if (cur.key == key) {
                cur.val = value;
                return;
            }
            cur = cur.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = head;
        bucket[index] = newNode;
    }

    public void remove(int key) {
        int index = getIndex(key);
        Node cur = bucket[index];
        Node prev = null;

        while (cur != null) {
            if (cur.key == key) {
                if (prev == null) {
                    bucket[index] = cur.next;
                    return;
                } else {
                    prev.next = cur.next;
                }
            }
            prev = cur;
            cur = cur.next;
        }
    }

    public int get(int key) {
        int index = getIndex(key);
        Node cur = bucket[index];

        while (cur != null) {
            if (cur.key == key) {
                return cur.val;
            }

            cur = cur.next;
        }

        return -1;
    }

}
