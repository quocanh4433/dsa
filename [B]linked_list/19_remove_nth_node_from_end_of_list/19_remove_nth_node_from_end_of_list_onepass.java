
@SuppressWarnings("unused")
class RemoveNthNodeFromEndOfList_TwoPass {

    /*

        one pass ~ traverse list 1 times

        for interview
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
        
        /*
            tại sao chỉ đi đến i < len - n mà không phải i <= len - n?

            vd: 
            
            1 -> 2 -> 3 -> 4 -> 5 
            n = 2
            len = 5

            for đi từ 1 đến 2

            i = 1 -> cur = cur.next = 2
            i = 2 -> cur = cur.next = 3 (node cần đến) ✅
            
            nếu cho i đi từ 1 đến 3 thì khi i = 3

            i = 3 -> cur = cur.next = 4 (vươt qua node cần đến là 3) ❌
        */
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
