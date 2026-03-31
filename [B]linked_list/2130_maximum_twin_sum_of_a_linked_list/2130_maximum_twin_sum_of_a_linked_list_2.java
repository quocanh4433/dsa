
@SuppressWarnings("unused")
class MaximumTwinSumOfALinkedList_2 {

    /*
        time O(n)
        space O(1)
     */
    public int pairSum(ListNode head) {
        if (head == null) {
            return 0;
        }

        // find second half
        ListNode secondHalf = findMid(head);

        // revers second half
        ListNode newSecondHalf = reverse(secondHalf);

        // calcaulate maximum
        ListNode first = head;
        ListNode second = newSecondHalf;
        int res = 0;
        while (second != null) {
            res = Math.max(res, first.val + second.val);
            first = first.next;
            second = second.next;
        }
        return res;
    }

    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        return second;
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode res = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = res;
            res = cur;
            cur = next;
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
