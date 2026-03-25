
@SuppressWarnings("unused")
class RemoveNthNodeFromEndOfList_OnePass {

    /*
        time O(n)
        space O(1)

        interview-friendly 👍

        one pass ~ traverse list 1 time

        idea
            ▪︎ using two pointers: fast and slow
            ▪︎ move fast ahead by n + 1 steps (starting from dummy)
            ▪︎ then, move both fast and slow 1 step at a time
            ▪︎ when fast = null, slow at right before the node to be remove

        for interview

            d   1   2   3   x   5   null
    slow                ^
    fast                            ^    

     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        for(int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

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
