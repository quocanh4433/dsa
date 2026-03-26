
@SuppressWarnings("unused")
class ReverseLinkedList_1 {
    /*
        time O(n)
        space O(n) ~ create new node
    */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode res = null;

        while (cur != null) {
            ListNode newNode = new ListNode(cur.val);
            newNode.next = res;

            res = newNode;
            cur = cur.next;
        }

        return res;
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
