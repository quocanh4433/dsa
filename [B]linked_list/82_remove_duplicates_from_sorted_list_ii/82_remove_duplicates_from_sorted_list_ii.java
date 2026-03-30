
@SuppressWarnings("unused")
class RemoveDuplicatesFromSortedListII {
    /*
        time O(n)
        space O(1)

        idea:
            if the current node's value equal the next node's value, using while loop to skip all entrie duplicte block 
        
    */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode cur = head;

        while(cur != null) {
            // case duplicate
            if(cur.next != null && cur.val == cur.next.val) {
                // skip all duplicates
                while(cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }

                // remove entire duplicate block
                prev.next = cur.next;
            } else {
                prev = cur;
            }
          
            cur = cur.next;
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
