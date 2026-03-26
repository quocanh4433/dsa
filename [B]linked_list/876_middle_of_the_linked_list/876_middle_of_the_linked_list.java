
@SuppressWarnings("unused")
class MiddleOfTheLinkedList {

    /*
        time O(n)
        space O(1)

        because the fast pointer moves twice as fast as slow pointer
        so when the fast pointer reaches the end of the list, the slow pointer is at the middle (approximately n/2)
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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
