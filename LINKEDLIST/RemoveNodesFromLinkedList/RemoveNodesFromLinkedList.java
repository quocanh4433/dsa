package RemoveNodesFromLinkedList;

public class RemoveNodesFromLinkedList {

    /*
     * 🧠 Idea: đảo ngươc linked list 
     * 
     * Time complexity: O(n)
     * Space complexity: O(1)
     * 
     */
    public static ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 1️⃣ Đảo ngược danh sách
        head = reverseList(head);

        // 2️⃣ Duyệt từ đầu (thực chất là từ phải sang trái ban đầu)
        int max = head.val; // 8
        ListNode node = head; // after reverse: 8 -> 3 -> 13 -> 5 -> 2

        while (node != null && node.next != null) {
            if (node.next.val < max) {
                node.next = node.next.next;
            } else {
                node = node.next;
                max = node.val;
            }
        }

        // 3️⃣ Đảo ngược lại để khôi phục thứ tự gốc
        return reverseList(head);

    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode res = null;

        while (head != null && head.next != null) {
            ListNode next = head.next;
            head.next = res;
            res = head;
            head = next;

        }

        return res;
    }

    public static void main(String[] args) {

    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
