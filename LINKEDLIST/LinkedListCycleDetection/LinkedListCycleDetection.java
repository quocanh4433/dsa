
package LinkedListCycleDetection;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleDetection {

    /*
     * SOLUTION 1: SET
     * 
     * Time complexity: O(n)
     * 
     * Space complexity: O(n)
     * 
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        Set<ListNode> seen = new HashSet<>();

        while (head != null) {
            if (seen.contains(head)) {
                return true;
            }
            seen.add(head);
            head = head.next;
        }

        return false;
    }

    /*
     * SOLUTION 1: FAST - SLOW
     * 
     * Time complexity: O(n)
     * 
     * Space complexity: O(1)
     * 
     */
    public boolean hasCycle_2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) { // ⚠️ so sánh địa chỉ (reference)
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {

    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
