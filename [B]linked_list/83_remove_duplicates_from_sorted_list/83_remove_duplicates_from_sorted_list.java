
@SuppressWarnings("unused")
class RemoveDuplicatesFromSortedList {

    /*
        time O(n)
        space O(1)

        idea
            when the current node's value equals the next node's value,
            we using while loop to skip all consecutive nodes that have the same value,
            so that only the one unique node remian in the list

        🔥 Short & clean version
            If the current node equals the next node, keep moving forward using a while loop to skip duplicates.
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            while (next != null && cur.val == next.val) {
                cur.next = next.next;
                next = next.next;
            }
            cur = next;
        }

        return head;
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
