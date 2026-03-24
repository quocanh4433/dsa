
@SuppressWarnings("unused")
class OddEvenLinkedList {
    /*
        time O(n)
        space O(1)
    */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        // bắt đầu từ node even
        while (even != null && even.next != null) {
            odd.next = even.next; // nối odd
            odd = odd.next;

            even.next = odd.next; // nối even với node chẵng tiếp theo
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}
class ListNode {

    int val;
    ListNode next;

    @SuppressWarnings("unused")
    ListNode(int val) {
        this.val = val;
    }

    @SuppressWarnings("unused")
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}