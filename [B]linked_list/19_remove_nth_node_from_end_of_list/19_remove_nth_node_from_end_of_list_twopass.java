
class RemoveNthNodeFromEndOfList_TwoPass {

    /*

        two pass ~ traverse list 2 times
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // pass 1: couting length
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        if (len == n) {
            return head.next;
        }

        // pass 2: đi tới node trước node cần xóa
        cur = head;
        for (int i = 1; i < len - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;

        return head;
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    @SuppressWarnings("unused")
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
