
@SuppressWarnings("unused")
class RemoveNthNodeFromEndOfList_OnePass {

    /*
        time O(n)
        space O(1)

        
        one pass ~ traverse list 1 time

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
