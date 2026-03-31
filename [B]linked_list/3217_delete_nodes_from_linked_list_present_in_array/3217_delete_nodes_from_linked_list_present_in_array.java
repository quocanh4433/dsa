
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
class DeleteNodesFromLinkedListPresentInArray {

    /*
        time O(n + m)
            n: length list
            m: lengh nums
        space O(m)
     */
    public ListNode modifiedList(int[] nums, ListNode head) {
        if (head == null) {
            return null;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (set.contains(cur.val)) {
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
