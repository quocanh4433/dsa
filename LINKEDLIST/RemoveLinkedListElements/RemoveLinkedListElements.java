package RemoveLinkedListElements;

public class RemoveLinkedListElements {


    /*
     * Time complexity: O(n)
     * 
     * Space complexity: O(1)
     * 
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        // 1️⃣ Tạo node giả trỏ tới đầu danh sách thật
        ListNode ans = new ListNode(-1, head);

        // 2️⃣ Con trỏ curr để duyệt danh sách (bắt đầu từ ans)
        ListNode curr = ans;

        // 3️⃣ Duyệt toàn bộ danh sách qua curr.next
        while (curr.next != null) {
            if (curr.next.val == val) {
                // Nếu node kế tiếp cần xóa, bỏ qua nó
                ListNode nextNode = curr.next.next;
                curr.next = nextNode;
            } else {
                curr = curr.next;
            }
        }

        // 4️⃣ Trả về danh sách thật (bỏ node giả)
        return ans.next;
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
