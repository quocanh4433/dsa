
@SuppressWarnings("unused")
class SwapNodesInPairs {
    /*
        time O(n)
        space O(1)
    */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = dummy.next;

        /*
        dummy -> 2 -> 1 -> 3 -> null
                      p     c
        
         */
        while (cur != null && cur.next != null) {
            ListNode next = cur.next; // 2
            ListNode temp = next.next; // 3
            next.next = cur; // 2 -> 1
            cur.next = temp; // 2 -> 1 -> 3
            prev.next = next; // dumy ->  2 -> 1 -> 3
            prev = cur;
            cur = temp;
        }

        return dummy.next;
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
