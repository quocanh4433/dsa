
@SuppressWarnings("unused")
class RotateList {

    /*
        time O(n)
        space O(1)
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // compute the length and locate the tail
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        // reduce k using modulo
        // n = 5
        // k = 5 -> same list
        // k = 10 -> same list
        // k = 15 -> same list
        k = k % n;
        if (k == 0) {
            return head;
        }

        // connect tail to head to form a cycle
        tail.next = head;

        // find new tail (cut position)
        ListNode newTail = head;
        for (int i = 1; i < n - k; i++) {
            newTail = newTail.next;
        }

        // break the cyvle to form new list
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
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
