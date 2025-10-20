
public class RemoveNthNodeFromEndOfList {

    /*

    SOLUTION 1: Two Pointers

    🕓 Time complexity: O(n)
    💾 Space complexity: O(1)
    
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        
        Xóa phần tử thứ 2 từ cuối mảng
        head = [1,2,3,4,5], n = 2

        -1 -> 1 -> 2 -> 3 -> 4* -> 5 -> null
        d
                        l              r
         */

        ListNode result = new ListNode(-1, head);
        ListNode left = result;
        ListNode right = head;

        for (int i = 1; i <= n; i++) {
            right = right.next;
        }

        while (right != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;
        return result.next;
    }

    /*

    SOLUTION 2: Two Pointers

    🕓 Time complexity: O(n)
    💾 Space complexity: O(1)

    💡 Phương pháp này gọi là duyệt 2 lần (two-pass iteration) vì:

    1️⃣ Lần đầu – đếm tổng số node (length)
    2️⃣ Lần hai – duyệt lại đến node trước node cần xoá
    
     */
    public ListNode removeNthFromEnd_2(ListNode head, int n) {

        // B1: đếm số node
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length += 1;
            node = node.next;
        }

        // B2: Khởi tạo result
        ListNode result = new ListNode(-1, head);
        node = result;

        // B3: Duyêt từ đầu đến node cần xóa
        for (int i = 0; i < length - n; i++) {
            node = node.next;
        }

        // B4: Gặp node cần xóa thì bỏ qua
        node.next = node.next.next;

        return result.next;

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
