
@SuppressWarnings("unused")
class SortList_Recursion {

    /*
        time O(n logn)
            - find the middle O(logn) ~ logarit 2
            - merge O(n)

        space O(logn) ~ call stack
    */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // find the middle
        ListNode mid = getMid(head);

        // middle divide list into 2 parts left and right
        ListNode right = mid.next;
        mid.next = null;
        ListNode left = head;

        // sort each part
        right = sortList(right);
        left = sortList(left);

        // merge both of them
        // merge two sorted list
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        if (left == null && right == null) {
            return null;
        }
        if (left == null || right == null) {
            return left == null ? right : left;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }

            cur = cur.next;
        }

        if (left == null) {
            cur.next = right;
        } else {
            cur.next = left;
        }

        return dummy.next;
    }

    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
