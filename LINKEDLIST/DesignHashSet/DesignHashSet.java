public class DesignHashSet {
    /*
    
    add() 
        Time: O(1) - worst case: O(n)
    
    contains() 
        Time: O(1) - worst case: O(n)
    
    remove() 
        Time: O(1) - worst case: O(n)

    Space:
        - mảng set: O(SIZE)
        - mỗi key 1 node -> n key -> O(n)
        -> O(SIZE + n) = O(n) 🔹
    
    */
    
    private class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    public int getIndex(int key) {
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

    private final Node[] set;
    private final int SIZE = 10000;

    public MyHashSet() {
        set = new Node[SIZE];
    }

    public void add(int key) {
        int index = getIndex(key);
        Node head = set[index];
        Node curr = head;
        while (curr != null) {
            // HashSet không được trùng value
            if (curr.key == key) {
                return;
            }
            curr = curr.next;
        }
        // hêm node mới vào đầu list
        Node newNode = new Node(key);
        newNode.next = head;
        set[index] = newNode;
    }

    public void remove(int key) {
        int index = getIndex(key);
        Node curr = set[index];
        Node prev = null;
        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) { // xóa node đầu
                    set[index] = curr.next;
                } else { // xóa node giữa/cuối
                    prev.next = curr.next;
                }
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public boolean contains(int key) {
        int index = getIndex(key);
        Node curr = set[index];
        while (curr != null) {
            if (curr.key == key) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
    
    public static void main(String[] args) {
        
    }
}
