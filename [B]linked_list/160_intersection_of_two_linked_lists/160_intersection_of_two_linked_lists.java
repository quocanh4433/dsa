
@SuppressWarnings("unused")
class IntersectionOfTwoLinkedLists {

    /*
        time O(n + m)
        space O(1)

        👉 Important:
            - Intersection is based on reference, not value.
            - After the intersection point, both lists share the same nodes.

        idea
            by switching head, both pointers traverse exactly the same total distance (A + B),
            which guarantees they align at the intersection or null
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
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
