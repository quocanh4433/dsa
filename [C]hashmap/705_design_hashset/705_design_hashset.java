
class MyHashSet {

    /*
    
    add() 
        time: O(1) - worst case: O(n)
    
    contains() 
        time: O(1) - worst case: O(n)
    
    remove() 
        time: O(1) - worst case: O(n)

    space:
        - mảng set: O(SIZE)
        - mỗi key 1 node -> n key -> O(n)
        -> O(SIZE + n) = O(n) 🔹
    
     */
    class Node {

        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private final Node[] set;
    private final int SIZE = 10000;

    public MyHashSet() {
        set = new Node[SIZE];
    }

    private int getIndex(int key) {
        /*  
            Chuyển key sang index trong mảng set
        
            key = 5      → 5 % 10000 = 5
            key = 10005 → 10005 % 10000 = 5
            key = 20005 → 20005 % 10000 = 5

            key khác nhau nhưng index = 5 giống nhau

            -> COLLISTION trong HashSet và HashTable

            ✍️ Tại sao key % SIZE?
         */
        return key % SIZE;
    }

    public void add(int key) {
        int index = getIndex(key);
        Node head = set[index];
        Node cur = head;

        // kiểm tra key đã xuất hiện trong set chưa
        while (cur != null) {
            if (cur.val == key) {
                return;
            }
            cur = cur.next;
        }

        Node newNode = new Node(key);
        // thêm vào đầu danh sách
        newNode.next = head;
        // cập nhật lại danh sách
        set[index] = newNode;
    }

    public void remove(int key) {
        int index = getIndex(key);
        Node cur = set[index];
        Node prev = null;

        while (cur != null) {
            if (cur.val == key) {
                if (prev == null) {
                    set[index] = cur.next;
                } else {
                    prev.next = cur.next;
                }
                break;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    public boolean contains(int key) {
        int index = getIndex(key);
        Node cur = set[index];

        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }

        return false;
    }
}
