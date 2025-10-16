
public class ReverseLinkedList {

    /**
     * SOLUTION 1:
     *
     * Time complexity: O(n)
     *
     * Space complexity: O(1)
     *
     *
     */
    static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curNode = head;
        ListNode res = null;
        while (curNode != null) {
            ListNode nextN = curNode.next;
            curNode.next = res;
            res = curNode;
            curNode = nextN;
        }

        return res;
    }

    /**
     * SOLUTION 2: CREATE NEW NODE - NOT OPTIMIZED
     *
     * Time complexity: O(n)
     *
     * Space complexity: O(n)
     */
    static ListNode reverseList_2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curNode = head;
        ListNode res = null;

        while (curNode != null) {
            ListNode newNode = new ListNode(curNode.val);
            newNode.next = res;

            res = newNode;
            curNode = curNode.next;
        }

        return res;
    }

    // 🔹 Hàm in danh sách
    static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) {
                System.out.print(" -> ");
            }
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 🔹 Tạo danh sách: 1 → 2 → 3 → 4 → 5
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        System.out.print("Before reverse: ");
        printList(head);

        // 🔹 Gọi hàm đảo
        ListNode reversed = reverseList(head);
        ListNode reversed2 = reverseList_2(head);

        System.out.print("After reverse: ");
        printList(reversed);
        printList(reversed2);
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * head prev 0 -> 1 -> 2 -> 3 -> 4 cur next
 *
 */
