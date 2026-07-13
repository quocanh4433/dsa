
import java.util.Random;

class Skiplist {

    /*

        Thao tác	    Time	                Extra Space
        search()	    O(log n) average,       O(n) worst	O(1)
        add()	        O(log n) average,       O(n) worst	O(1) (LeetCode, vì MAX_LEVEL là hằng số)
        erase()	        O(log n) average,       O(n) worst	O(1) (LeetCode)


        ----------------------------------------------------

        skiplist tạo ra để tìm, xóa, thêm như cây cân bằng nhưng đơn giản hơn
        
        *Linkedlist*
        vấn đề của linkedlist:  1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
        muốn tìm 8 mất O(n)

        
        *Skiplist*
        level 2:
        1 -----------------------> 9

        level 1:
        1 --------> 5 -----------> 9

        level 0:
        1 ->2->3->4->5->6->7->8->9

        muốn tìm 8: 
        - đi level 2 thấy 9 > 8 xuống 1
        - đi level 1 thất 5 < 8 xuống 0
        - đi tiếp 6 -> 7 -> 8 
        không cần đi qua tất cả các node
    
     */
    private static final int MAX_LEVEL = 16;
    private static final double P = 0.5;

    class Node {

        int val;
        Node[] next;

        Node(int val, int level) {
            this.val = val;
            next = new Node[level];
        }
    }

    private final Node head;
    private int level;
    private final Random random;

    public Skiplist() {
        this.head = new Node(-1, MAX_LEVEL);
        this.level = 1;
        this.random = new Random();

    }

    private int randomLevel() {
        int lv = 1;

        while (lv < MAX_LEVEL && random.nextDouble() < P) {
            lv++;
        }

        return lv;
    }

    public boolean search(int target) {
        Node cur = head;

        for (int i = level - 1; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].val < target) {
                cur = cur.next[i];
            }
        }

        cur = cur.next[0];

        return cur != null && cur.val == target;
    }

    public void add(int num) {
        Node[] update = new Node[MAX_LEVEL];
        Node cur = head;

        // tìm vị trí chèn
        for (int i = level - 1; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].val < num) {
                cur = cur.next[i];
            }
            update[i] = cur;
        }

        // sinh level cho node mới
        int newLevel = randomLevel();

        if (newLevel > level) {
            for (int i = level; i < newLevel; i++) {
                update[i] = head;
            }

            level = newLevel;
        }

        Node node = new Node(num, newLevel);

        // chèn node
        for (int i = 0; i < newLevel; i++) {
            node.next[i] = update[i].next[i];
            update[i].next[i] = node;
        }
    }

    public boolean erase(int num) {
        Node[] update = new Node[MAX_LEVEL];
        Node cur = head;

        for (int i = level - 1; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].val < num) {
                cur = cur.next[i];
            }

            update[i] = cur;
        }

        // lấy node cần xóa
        cur = cur.next[0];

        // kiểm tra node có tồn tại không
        if (cur == null || cur.val != num) {
            return false;
        }

        // xoá node ở từng tầng
        for (int i = 0; i < level; i++) {
            if (update[i].next[i] != cur) {
                break;
            }

            update[i].next[i] = cur.next[i];
        }

        // giảm số tầng nếu cần
        while (level > 1 && head.next[level - 1] == null) {
            level--;
        }

        return true;
    }

    public static void main(String[] args) {
        Skiplist skl = new Skiplist();

        System.out.println("add(1)");
        skl.add(1);

        System.out.println("add(2)");
        skl.add(2);

        System.out.println("add(3)");
        skl.add(3);

        System.out.println("search(0) = " + skl.search(0)); // false

        System.out.println("add(4)");
        skl.add(4);

        System.out.println("search(1) = " + skl.search(1)); // true

        System.out.println("erase(0) = " + skl.erase(0)); // false

        System.out.println("erase(1) = " + skl.erase(1)); // true

        System.out.println("search(1) = " + skl.search(1)); // false
    }
}
/*


✴️ add(1)

1/. khởi tạo

    update = [
        [0] = null
        [1] = null
        [2] = null
        ...
        [15] = null
    ]

    cur = {
        val = -1;
        next = [
            [0] = null
            [1] = null
            ...
            [15] = null
        ]
    }

2/. tìm vị trí chèn
    
    level = 1

    i = level - 1 = 0

    cur.next[0] == null bỏ qua while

    update[0] = cur;

    update lúc này:
    update = [
        [0] = {
            val = -1;
            next = [
                [0] = null
                [1] = null
                ...
                [15] = null
            ]
        }
        [1] = null
        [2] = null
        ...
        [15] = null
    ]

3/. sinh level mới cho node
    
    newLevel = 1 (random)
    newLevel == level bỏ qua

4/. tạo node

    node = {
        val: 1
        next = [
            [0] = null
        ]
    }

5/. chèn node











*/
