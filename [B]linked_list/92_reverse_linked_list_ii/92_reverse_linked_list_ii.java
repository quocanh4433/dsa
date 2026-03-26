
@SuppressWarnings("unused")
class ReverseLinkedListII {

    /*
        time O(n)
        space O(1)

        ý tưởng 
            đưa node kết node left về phía trước
            chuyển dần node left về phía sau cho đến vị trí right

            
        1   2   3   4   5   6
        ^
            ^
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        // move prev to node before left
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode cur = prev.next;

        for (int i = 0; i < right - left; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
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
