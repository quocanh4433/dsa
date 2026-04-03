
@SuppressWarnings("unused")
class ReverseNodesInKGroup {

    /*
        time O(n)
        space O(1)
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode prevDummy = dummy;
        ListNode cur = head;

        while (cur != null) {

            int count = 1;
            ListNode temp = cur;
            while (temp != null && temp.next != null && count < k) {
                count++;
                temp = temp.next;
            }

            if (count == k) {
                ListNode prev = null;
                ListNode node = cur;

                for (int i = 0; i < k; i++) {
                    ListNode nextNode = node.next; // 2
                    node.next = prev;
                    prev = node;
                    node = nextNode;
                }

                // node (next group)
                // prev = head after reverse
                // cur = tail after reverse 
                prevDummy.next = prev;
                prevDummy = cur;
                cur = node;
            } else {
                prevDummy.next = cur;
                for (int i = 0; i < count; i++) {
                    cur = cur.next;
                }
            }

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
