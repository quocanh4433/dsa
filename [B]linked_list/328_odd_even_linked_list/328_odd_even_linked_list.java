
@SuppressWarnings("unused")
class OddEvenLinkedList {
    /*
        time O(n)
        space O(1)

        idea: using 3 pointer odd, even, evenhead
    */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next; // connect to next odd
            odd = odd.next;

            even.next = odd.next; // connect event to next even node
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}
class ListNode {

    @SuppressWarnings("unused")
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