
public class ReorderLinkedList {

    /* 
    🕓 Time complexity:  O(n)
    💾 Space complexity: O(1)
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;

        // Splitting the List
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;

        // Reversing the Second Half
        ListNode reverse = null;
        while (second != null) {
            ListNode next = second.next;
            second.next = reverse;
            reverse = second;
            second = next;
        }
        second = reverse;
        ListNode first = head;
        /*
        second: 5 -> 4 -> null*
         
        first: 1 -> 2 -> 3* -> 4 -> 5

        firstNext: 3
        secondNext: null

        1 -> 5 -> 2 -> 4 -> 3

         */

        //  Merging the Two Halves
        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
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
